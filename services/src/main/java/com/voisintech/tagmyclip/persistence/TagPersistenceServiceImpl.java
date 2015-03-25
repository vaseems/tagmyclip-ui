package com.voisintech.tagmyclip.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voisintech.tagmyclip.model.TagPersistence;

@Service
public class TagPersistenceServiceImpl implements TagPersistenceService{

	@Autowired
	TagPersistRepository tagPersistRepository;

	@Override
	public TagPersistence save(TagPersistence tag) {
		return tagPersistRepository.save(tag);
	}
}
