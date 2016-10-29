package com.jam.module.collect.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.collect.entity.Collect;
import com.jam.module.topic.entity.Topic;
import com.jam.module.user.entity.User;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface CollectDao extends JpaRepository<Collect, Integer> {

    Page<Collect> findByUser(User user, Pageable pageable);

    long countByUser(User user);

    long countByTopic(Topic topic);

    Collect findByUserAndTopic(User user, Topic topic);

}
