package com.jam.module.suggestion.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.suggestion.entity.Suggestion;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface SuggestionDao extends JpaRepository<Suggestion, Integer> {

	Page<Suggestion> findByReplyCount(int i, Pageable pageable);
}
