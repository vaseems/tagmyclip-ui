package com.voisintech.tagmyclip.model;


import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.voisintech.tagmyclip.solr.core.SearchableProductDefinition;

@SolrDocument(solrCoreName="tagmyclip")
public class TagSolr implements SearchableProductDefinition{
	
	@Indexed(TAGNAME_FIELD_NAME)
	private String tagName;
	@Id @Indexed(TAG_ID_FIELD_NAME)
	private String id;
	@Indexed(VIDEO_SOURCE_FIELD_NAME)
	private String source;
	@Indexed(CREATED_BY_FIELD_NAME)
	private String createdBy;
	@Indexed(VIDEO_ID_FIELD_NAME)
	private String videoId;
	@Indexed(SEEK_TIME_FIELD_NAME)
	private String seekTime;

	public TagSolr(){
		
	}
	
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + tagName + "]";
	}
}
