package com.jam.module.topic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.jam.common.BaseEntity;
import com.jam.module.user.entity.User;

import java.util.Date;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Entity
@Table(name = "cs_topic")
@Getter
@Setter
public class Topic extends BaseEntity {

	@Id
	@GeneratedValue
	private int id;

	// 版块
	@Column(nullable = false)
	private String tab;

	// 标题
	@Column(unique = true, nullable = false)
	private String title;

	// 内容
	@Column(columnDefinition = "text")
	private String content;

	// 发布时间
	@Column(nullable = false)
	private Date inTime;

	// 修改时间
	private Date modityTime;

	// 是否置顶
	private boolean top;

	// 是否精华
	private boolean good;

	// 点赞个数
	@Column(nullable = false)
	private int up;

	// 浏览数
	@Column(nullable = false)
	private int view;

	// 与用户的关联关系
	@ManyToOne
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	// 回复数
	@Column(name = "reply_count")
	private int replyCount;

	@Column(columnDefinition = "text")
	// 点赞用户id，逗号隔开(英文逗号)
	private String upIds;
}
