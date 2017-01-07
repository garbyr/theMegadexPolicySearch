package com.megadex;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {
private String searchType;
private String anyOf;
private String allOf;
private List<String> anyOfPhrase;
private List<String> allOfPhrase;

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

public List<String> getAnyOfPhrase() {
	return anyOfPhrase;
}

public void setAnyOfPhrase(List<String> anyOfPhrase) {
	this.anyOfPhrase = anyOfPhrase;
}


public List<String> getAllOfPhrase() {
	return allOfPhrase;
}

public void setAllOfPhrase(List<String> allOfPhrase) {
	this.allOfPhrase = allOfPhrase;
}
}