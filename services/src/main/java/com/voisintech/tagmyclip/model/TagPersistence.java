package com.voisintech.tagmyclip.model;

public class TagPersistence {

	private String tagName = "";
	private String id = "";
	private String source = "";
	private String createdBy = "";
	private String videoId = "";
	private String seekTime = "";
	private String created = "";
	private String viewCount = "";

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getSeekTime() {
		return seekTime;
	}

	public void setSeekTime(String seekTime) {
		this.seekTime = seekTime;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + tagName + "]";
	}
}
