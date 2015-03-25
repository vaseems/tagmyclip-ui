package com.voisintech.tagmyclip.solr;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.Query.Operator;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.voisintech.tagmyclip.model.TagSolr;
import com.voisintech.tagmyclip.solr.core.SearchableProductDefinition;


public interface TagSolrRepository extends SolrCrudRepository<TagSolr, String>{
	
	
	@Query(fields = { SearchableProductDefinition.TAG_ID_FIELD_NAME, SearchableProductDefinition.TAGNAME_FIELD_NAME,
			SearchableProductDefinition.VIDEO_ID_FIELD_NAME,
			SearchableProductDefinition.CREATED_BY_FIELD_NAME }, defaultOperator = Operator.OR)
	Page<TagSolr> findByTagNameIn(Collection<String> name, Pageable page);
	
	@Query(value = "name:?0")
	@Facet(fields = { "cat" }, limit=20)
	FacetPage<TagSolr> findByTagNameAndFacetOnCategory(String name, Pageable page);

}
