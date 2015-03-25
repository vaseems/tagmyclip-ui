package com.voisintech.tagmyclip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.voisintech.tagmyclip.config.PersistenceContext;
import com.voisintech.tagmyclip.config.SolrContext;

@SpringBootApplication
@Import({SolrContext.class, PersistenceContext.class})
public class TagMyClipApplication  {
	public static void main(String[] args){
		SpringApplication app = new SpringApplication(TagMyClipApplication.class);
	    app.setShowBanner(false);
	    app.run(args);
	}
}