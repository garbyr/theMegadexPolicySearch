package com.megadex;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ElasticSearch {
	
	private Search s;
	private String urlString = "http://localhost:9200/policy";
	
	public ElasticSearch(Search s){
		this.s = s;
	}

	public ResponseEntity<ElasticResponseWrapper> doSearch(){
		/* create rest template and uri */
		RestTemplate rt = new RestTemplate();
		//shortcut the url for specific searches
		if(s.getSearchType().equals("current")){
			urlString += "_current_v0.1/policy/_search?pretty";
		} else {
			urlString += "/_search?pretty";
		}
		/* create body */
		String JO = new BodyBuilder(s).buildBody().toString();
		/*create headers*/
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		/* create http entity */
		HttpEntity<String> entity = new HttpEntity<String>(JO, headers);
		ResponseEntity<ElasticResponseWrapper> searchResponse = rt
				  .exchange(urlString, HttpMethod.POST, entity, ElasticResponseWrapper.class);
			
		return searchResponse;

	}
}
