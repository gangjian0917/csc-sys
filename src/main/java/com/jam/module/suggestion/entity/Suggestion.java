package com.jam.module.suggestion.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jam.common.BaseEntity;
import com.jam.module.user.entity.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Entity
@Table(name = "cs_suggestion")
@Getter
@Setter
public class Suggestion extends BaseEntity {

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
