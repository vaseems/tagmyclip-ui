package com.voisintech.tagmyclip.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "tagmyclip.solr")
public class ApplicationProperties {
	private String collectionName = "";
	private String urlString;

	public String getCollectionName() {
		return this.collectionName;
	}

	public String getUrlString() {
		return this.urlString;
	}
}
