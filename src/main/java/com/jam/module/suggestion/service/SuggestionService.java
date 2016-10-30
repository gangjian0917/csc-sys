package com.jam.module.suggestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jam.common.config.SiteConfig;
import com.jam.module.reply.service.ReplyService;
import com.jam.module.suggestion.dao.SuggestionDao;
import com.jam.module.suggestion.entity.Suggestion;
import com.jam.module.user.entity.User;
import com.jam.util.Constants;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Service
@Transactional
public class SuggestionService {

	@Autowired
	private SiteConfig siteConfig;
	@Autowired
	private SuggestionDao suggestionDao;
	@Autowired
	private ReplyService replyService;
	// @Autowired
	// private ElasticSuggestionService elasticSuggestionService;

	public void save(Suggestion suggestion) {
		suggestionDao.save(suggestion);
		/*
		 * if(siteConfig.isElastic()) { new Thread(() -> { ElasticSuggestion
		 * elasticSuggestion = new ElasticSuggestion();
		 * elasticSuggestion.setSuggestionId(suggestion.getId());
		 * elasticSuggestion.setTitle(suggestion.getTitle());
		 * elasticSuggestion.setContent(suggestion.getContent());
		 * elasticSuggestionService.save(elasticSuggestion); }).start(); }
		 */
	}

	public Suggestion findById(int id) {
		return suggestionDao.findOne(id);
	}

	/**
	 * 删除话题
	 *
	 * @param id
	 */
	public void deleteById(int id) {
		/*
		 * if(siteConfig.isElastic()) { new Thread(() -> { ElasticSuggestion
		 * elasticSuggestion = elasticSuggestionService.findBySuggestionId(id);
		 * elasticSuggestionService.delete(elasticSuggestion); }).start(); }
		 * //删除话题下面的回复 replyService.deleteBySuggestion(id);
		 */
		// 删除话题
		suggestionDao.delete(id);
	}

	/**
	 * 删除用户发的所有话题
	 * 
	 * @param user
	 */
	public void deleteByUser(User user) {
		suggestionDao.deleteByUser(user);
	}

	/**
	 * 分页查询话题列表
	 *
	 * @param p
	 * @param size
	 * @return
	 */
	public Page<Suggestion> page(int p, int size, String tab) {
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "inTime"));
		Pageable pageable = new PageRequest(p - 1, size, sort);
		if (tab.equals("全部")) {
			return suggestionDao.findAll(pageable);
		} else if (tab.equals("精华")) {
			return suggestionDao.findByGood(true, pageable);
		} else if (tab.equals("等待回复")) {
			return suggestionDao.findByReplyCount(0, pageable);
		} else {
			return suggestionDao.findByTab(tab, pageable);
		}
	}

	/**
	 * 点赞
	 *
	 * @param userId
	 * @param suggestionId
	 */
	public void addOneUp(int userId, int suggestionId) {
		Suggestion suggestion = findById(suggestionId);
		if (suggestion != null) {
			suggestion.setUp(suggestion.getUp() + 1);
			suggestion.setUpIds(suggestion.getUpIds() + userId + Constants.COMMA);
			save(suggestion);
		}
	}

	/**
	 * 取消点赞
	 *
	 * @param userId
	 * @param suggestionId
	 */
	public void reduceOneUp(int userId, int suggestionId) {
		Suggestion suggestion = findById(suggestionId);
		if (suggestion != null) {
			String upIds = suggestion.getUpIds();
			upIds = upIds.replace(Constants.COMMA + userId + Constants.COMMA, Constants.COMMA);
			suggestion.setUpIds(upIds);
			suggestion.setUp(suggestion.getUp() - 1);
			save(suggestion);
		}
	}

	/**
	 * 查询用户的话题
	 * 
	 * @param p
	 * @param size
	 * @param user
	 * @return
	 */
	public Page<Suggestion> findByUser(int p, int size, User user) {
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "inTime"));
		Pageable pageable = new PageRequest(p - 1, size, sort);
		return suggestionDao.findByUser(user, pageable);
	}

}
