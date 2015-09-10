package com.voisintech.tagmyclip.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.voisintech.tagmyclip.model.TagPersistence;
import com.voisintech.tagmyclip.model.TagSolr;
import com.voisintech.tagmyclip.persistence.TagPersistenceService;
import com.voisintech.tagmyclip.solr.TagService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api.voisintech.com/tag")
@Api(value = "/api.voisintech.com/tag")
public class TagMyClipController {

	@Autowired
	private Environment environment;
	@Autowired
	private TagService productService;
	@Autowired
	private TagPersistenceService tagPersistenceService;

	@RequestMapping("/")
	@ApiOperation(value = "/")
	public Response tagmyclip() {
		return Response.ok()
				.entity(new String("Vaseem Ibn Abbas, Enterpreneur")).build();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ApiOperation(value = "Create a new tag")
	public Response createNewTag(
			@ApiParam(required = true) @RequestBody TagPersistence tag) {
		return Response.ok().entity(tagPersistenceService.save(tag)).build();
	}

	@RequestMapping(value = "/search/{searchTerm}", method = RequestMethod.GET)
	@ApiOperation(value = "Search tags", response = TagSolr.class)
	public Response searchTag(
			@PathVariable String searchTerm,
			@PageableDefault(page = 0, size = TagService.DEFAULT_PAGE_SIZE) Pageable pageable) {
		try {
			return Response.ok()
					.entity(productService.findByName(searchTerm, pageable))
					.type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.serverError().build();
		}
	}
}
