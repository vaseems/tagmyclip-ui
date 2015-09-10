package com.voisintech.tagmyclip.solr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.voisintech.tagmyclip.model.TagSolr;

public interface TagService {

	int DEFAULT_PAGE_SIZE = 10;
	
	Page<TagSolr> findByName(String searchTerm, Pageable pageable);	
}
