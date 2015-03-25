package com.voisintech.tagmyclip.persistence;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.voisintech.tagmyclip.model.TagPersistence;

@Repository
public class TagPersistRepository {

	DataSource dataSource;

	JdbcTemplate jdbcTemplate;

	@Autowired
	public TagPersistRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public TagPersistence save(TagPersistence tag) {
		String query = "insert into tags (TagId, TagName, VideoId, SeekTime, TagCreatedBy, ViewCount, Source, created) values (?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query, tag.getId(), tag.getTagName(), tag.getVideoId(), tag.getSeekTime(), tag.getCreatedBy(), tag.getViewCount(), tag.getSource(), tag.getCreated());		
		return tag;
	}
}
