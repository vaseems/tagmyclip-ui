package com.voisintech.tagmyclip.persistence;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.voisintech.tagmyclip.model.TagPersistence;

public interface TagPersistenceRepository extends CrudRepository<TagPersistence, Serializable>{

}
