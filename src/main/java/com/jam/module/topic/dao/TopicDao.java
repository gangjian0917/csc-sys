package com.jam.module.topic.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.topic.entity.Topic;
import com.jam.module.user.entity.User;

import java.util.List;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface TopicDao extends JpaRepository<Topic, Integer> {

    Page<Topic> findByTab(String tab, Pageable pageable);

    Page<Topic> findByUser(User user, Pageable pageable);

    void deleteByUser(User user);

    Page<Topic> findByGood(boolean b, Pageable pageable);

    Page<Topic> findByReplyCount(int i, Pageable pageable);
}
