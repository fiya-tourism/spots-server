package com.fy.spotsserver.Util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class selectlikes {
	
	private String likeName;
	private Integer likeSex;
	private Integer likeGroup;
	private String likeDateB;
	private String likeDateE;
	private String likeImg;
	private String likeLike;
	
	public String getLikeName() {
		return likeName;
	}
	public void setLikeName(String likeName) {
		this.likeName = likeName;
	}
	public Integer getLikeSex() {
		return likeSex;
	}
	public void setLikeSex(Integer likeSex) {
		this.likeSex = likeSex;
	}
	public Integer getLikeGroup() {
		return likeGroup;
	}
	public void setLikeGroup(Integer likeGroup) {
		this.likeGroup = likeGroup;
	}
	public String getLikeDateB() {
		return likeDateB;
	}
	public void setLikeDateB(String likeDateB) {
		this.likeDateB = likeDateB;
	}
	public String getLikeDateE() {
		return likeDateE;
	}
	public void setLikeDateE(String likeDateE) {
		this.likeDateE = likeDateE;
	}
	public String getLikeImg() {
		return likeImg;
	}
	public void setLikeImg(String likeImg) {
		this.likeImg = likeImg;
	}
	public String getLikeLike() {
		return likeLike;
	}
	public void setLikeLike(String likeLike) {
		this.likeLike = likeLike;
	}
	

	
	
	
}
