package com.megadex;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ElasticResponseHeader {
	private int total;
	private List<ElasticResponseDetail> hits;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<ElasticResponseDetail> getHits() {
		return hits;
	}
	public void setHits(List<ElasticResponseDetail> hits) {
		this.hits = hits;
	}
}
