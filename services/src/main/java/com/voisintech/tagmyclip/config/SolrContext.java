package com.voisintech.tagmyclip.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = {"com.voisintech.tagmyclip"}, multicoreSupport = true)
public class SolrContext {

	private static final String SOLR_SERVER_URL = "${tagmyclip.solr.urlString}";
	
	@Bean
	public SolrServer solrServer(@Value(SOLR_SERVER_URL) String solrHost) {
		return new HttpSolrServer(solrHost);
	}
	
}