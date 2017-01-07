package com.megadex;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ElasticResponseWrapper {

	private String message;
	private ElasticResponseHeader hits;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ElasticResponseHeader getHits() {
		return hits;
	}

	public void setHits(ElasticResponseHeader hits) {
		this.hits = hits;
	}

	public MegadexResponseWrapperFull megadexify() {
		MegadexResponseWrapperFull mrw = new MegadexResponseWrapperFull();
		List<MegadexPolicyResponse> _mpr = mrw.getPolicies();
		List<ElasticResponseDetail> _erd = hits.getHits();
		for (ElasticResponseDetail temp : _erd) {
			String x = temp.get_type();
			if (x.equals("policy")) {
				MegadexPolicyResponse mpr = new MegadexPolicyResponse();
				mpr.setPolicy(temp.get_source().getPolicy());
				mpr.setEffectiveFromStamp(temp.get_source().getEffectiveFromStamp());
				mpr.setTransactionTimeStamp(temp.get_source().getTransactionTimeStamp());
				mpr.setPolicyholders(temp.get_source().getPolicyholders());
				mpr.setSourceApplication(temp.get_source().getSourceApplication());
				mpr.setSourceURI(temp.get_source().getSourceURI());
				_mpr.add(mpr);
			}
		}
		return mrw;
	}
}
