package com.megadex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {
private String searchType;
private String anyOf;
private String anyOfFuzzy;
private String allOf;
private String allOfFuzzy;
private String phrase;

public String getSearchType() {
	return searchType;
}

public void setSearchType(String searchType) {
	this.searchType = searchType;
}

public String getAnyOf() {
	return anyOf;
}

public void setAnyOf(String anyOf) {
	this.anyOf = anyOf;
}

public String getAllOf() {
	return allOf;
}

public void setAllOf(String allOf) {
	this.allOf = allOf;
}


public void setPhrase(String phrase) {
	this.phrase = phrase;
}

public String getPhrase() {
	return phrase;
}

public String getAnyOfFuzzy() {
	return anyOfFuzzy;
}

public String getAllOfFuzzy() {
	return allOfFuzzy;
}

public void setAnyOfFuzzy(String anyOfFuzzy) {
	this.anyOfFuzzy = anyOfFuzzy;
}

public void setAllOfFuzzy(String allOfFuzzy) {
	this.allOfFuzzy = allOfFuzzy;
}


}