package com.megadex;


import com.google.gson.JsonArray;
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
		JsonArray matchWrapperList = new JsonArray();
		JsonObject anyOfWrapper = new JsonObject();
		JsonObject anyOfWrapper2 = new JsonObject();
		JsonObject allOfWrapper = new JsonObject();
		JsonObject allOfWrapper2 = new JsonObject();
		queryWrapper.add("query", booleanWrapper);
		booleanWrapper.add("bool", mustWrapper);
		mustWrapper.add("should", matchWrapperList);
		if (s.getAnyOf() !=  null){
			JsonObject matchWrapper = new JsonObject();
			matchWrapper.add("match", anyOfWrapper);
			anyOfWrapper.addProperty("searchyStuff", s.getAnyOf());
			matchWrapperList.add(matchWrapper);
			if (s.getAnyOfFuzzy() != null && s.getAnyOfFuzzy().equals("true")){
				JsonObject matchWrapperFuzz = new JsonObject();
				matchWrapperFuzz.add("match", anyOfWrapper);
				anyOfWrapper.add("searchyStuff", anyOfWrapper2);
				anyOfWrapper2.addProperty("query", s.getAnyOf());
				anyOfWrapper2.addProperty("operator", "and");
				matchWrapperList.add(matchWrapperFuzz);
			}
		} 
		if (s.getAllOf() != null){
			JsonObject matchWrapper = new JsonObject();
			matchWrapper.add("match", allOfWrapper);
			allOfWrapper.add("searchyStuff", allOfWrapper2);
			allOfWrapper2.addProperty("query", s.getAllOf());
			allOfWrapper2.addProperty("operator", "and");
			matchWrapperList.add(matchWrapper);
			if (s.getAllOfFuzzy() != null &&s.getAllOfFuzzy().equals("true")){
				JsonObject matchWrapperFuzz = new JsonObject();
				allOfWrapper.add("searchyStuff", allOfWrapper2);
				allOfWrapper2.addProperty("query", s.getAllOf());
				allOfWrapper2.addProperty("operator", "and");
				allOfWrapper2.addProperty("fuzziness","AUTO");
				matchWrapperList.add(matchWrapperFuzz);
			}
		}
		if (s.getPhrase() != null){
			JsonObject matchWrapper = new JsonObject();
			matchWrapper.add("match", allOfWrapper);
			allOfWrapper.add("searchyStuff", allOfWrapper2);
			allOfWrapper2.addProperty("query", s.getPhrase());
			allOfWrapper2.addProperty("type", "phrase");
			matchWrapperList.add(matchWrapper);
		}
		return queryWrapper;
	}

}
