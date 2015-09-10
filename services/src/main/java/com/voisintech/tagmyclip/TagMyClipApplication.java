package com.voisintech.tagmyclip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.voisintech.tagmyclip.config.PersistenceContext;
import com.voisintech.tagmyclip.config.SolrContext;
import com.voisintech.tagmyclip.config.SwaggerConfig;

@SpringBootApplication
@Import({SolrContext.class, PersistenceContext.class, SwaggerConfig.class})
public class TagMyClipApplication  extends SpringBootServletInitializer{
	public static void main(String[] args){
		SpringApplication app = new SpringApplication(TagMyClipApplication.class);
	    app.setShowBanner(false);
	    app.run(args);
	}
}