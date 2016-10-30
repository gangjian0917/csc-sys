package com.jam.module.suggestion.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.suggestion.entity.Suggestion;
import com.jam.module.user.entity.User;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface SuggestionDao extends JpaRepository<Suggestion, Integer> {

	Page<Suggestion> findByTab(String tab, Pageable pageable);

	Page<Suggestion> findByUser(User user, Pageable pageable);

	void deleteByUser(User user);

	Page<Suggestion> findByGood(boolean b, Pageable pageable);

	Page<Suggestion> findByReplyCount(int i, Pageable pageable);
}
