package com.megadex;

import com.google.gson.JsonObject;

public class BodyBuilder {

	private Search s;
	
	public BodyBuilder(Search s){
		this.s = s;
	}
	
	public JsonObject buildBody(){
		JsonObject queryWrapper = new JsonObject();
		JsonObject booleanWrapper = new JsonObject();
		JsonObject mustWrapper = new JsonObject();
		JsonObject matchWrapper = new JsonObject();
		JsonObject anyOfWrapper = new JsonObject();
		JsonObject allOfWrapper = new JsonObject();
		JsonObject allOfWrapper2 = new JsonObject();
		queryWrapper.add("query", booleanWrapper);
		booleanWrapper.add("bool", mustWrapper);
		mustWrapper.add("must", matchWrapper);
		if (s.getAnyOf() !=  null){
			matchWrapper.add("match", anyOfWrapper);
			anyOfWrapper.addProperty("searchyStuff", s.getAnyOf());
		} 
		if (s.getAllOf() != null){
			matchWrapper.add("match", allOfWrapper);
			allOfWrapper.add("searchyStuff", allOfWrapper2);
			allOfWrapper2.addProperty("query", s.getAllOf());
			allOfWrapper2.addProperty("operator", "and");
		}
		return queryWrapper;
	}

}
