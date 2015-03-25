package com.voisintech.tagmyclip.solr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.voisintech.tagmyclip.model.TagSolr;

@Repository
public class TagServiceImpl implements TagService{
	
	private static final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");

	@Autowired
	TagSolrRepository solrProductRepository;

	@Override
	public Page<TagSolr> findByName(String searchTerm, Pageable pageable) {
		if (StringUtils.isBlank(searchTerm) || StringUtils.equals(searchTerm, "*")) {
			return solrProductRepository.findAll(pageable);
		}

		return solrProductRepository.findByTagNameIn(splitSearchTermAndRemoveIgnoredCharacters(searchTerm), pageable);
	}
	
	private Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm) {
		String[] searchTerms = StringUtils.split(searchTerm, " ");
		List<String> result = new ArrayList<String>(searchTerms.length);
		for (String term : searchTerms) {
			if (StringUtils.isNotEmpty(term)) {
				result.add(IGNORED_CHARS_PATTERN.matcher(term).replaceAll(" "));
			}
		}
		return result;
	}
}
