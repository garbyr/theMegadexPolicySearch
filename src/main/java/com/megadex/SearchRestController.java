
package com.megadex;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SearchRestController {
	
	private IMegadexResponseWrapper mrw;
	
	@RequestMapping(value="/current", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	  public IMegadexResponseWrapper buildSearch(@RequestBody Search s) {
		//check the request parameters
		s.setSearchType("current");
		ResponseEntity<ElasticResponseWrapper> gerw  =  new ElasticSearch(s).doSearch();
			//if we want to return all details do this...
			mrw = gerw.getBody().megadexify();
			//if we want to do something else do it here
		return mrw;
	  }
	
}

