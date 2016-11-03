package com.jam.module.suggestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jam.module.suggestion.dao.SuggestionDao;
import com.jam.module.suggestion.entity.Suggestion;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Service
@Transactional
public class SuggestionService {

	@Autowired
	private SuggestionDao suggestionDao;

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
	 * 删除吐槽
	 *
	 * @param id
	 */
	public void deleteById(int id) {
		/*
		 * if(siteConfig.isElastic()) { new Thread(() -> { ElasticSuggestion
		 * elasticSuggestion = elasticSuggestionService.findBySuggestionId(id);
		 * elasticSuggestionService.delete(elasticSuggestion); }).start(); }
		 * //删除吐槽下面的回复 replyService.deleteBySuggestion(id);
		 */
		// 删除吐槽
		suggestionDao.delete(id);
	}

	/**
	 * 分页查询吐槽列表
	 *
	 * @param p
	 * @param size
	 * @return
	 */
	public Page<Suggestion> page(int p, int size) {
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "inTime"));
		Pageable pageable = new PageRequest(p - 1, size, sort);
		/*
		 * if (tab.equals("全部")) { return suggestionDao.findAll(pageable); }
		 * else if (tab.equals("精华")) { return suggestionDao.findByGood(true,
		 * pageable); } else if (tab.equals("等待回复")) { return
		 * suggestionDao.findByReplyCount(0, pageable); } else { return
		 * suggestionDao.findByTab(tab, pageable); }
		 */

		return suggestionDao.findAll(pageable);
	}

}
