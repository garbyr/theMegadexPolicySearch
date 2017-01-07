package com.megadex;

import java.util.ArrayList;
import java.util.List;

public class MegadexPolicyResponse {

	private String policy;
	private String effectiveFromStamp;
	private String transactionTimeStamp;
	private String sourceApplication;
	private String sourceURI;
	private List<String> policyholders = new ArrayList<String>();
			
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public String getEffectiveFromStamp() {
		return effectiveFromStamp;
	}
	public void setEffectiveFromStamp(String effectiveFromStamp) {
		this.effectiveFromStamp = effectiveFromStamp;
	}
	
	public String getTransactionTimeStamp() {
		return transactionTimeStamp;
	}
	public void setTransactionTimeStamp(String transactionTimeStamp) {
		this.transactionTimeStamp = transactionTimeStamp;
	}
	public String getSourceApplication() {
		return sourceApplication;
	}
	public void setSourceApplication(String sourceApplication) {
		this.sourceApplication = sourceApplication;
	}
	public String getSourceURI() {
		return sourceURI;
	}
	
	public void setSourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
	}
	public List<String> getPolicyholders() {
		return policyholders;
	}
	public void setPolicyholders(List<String> policyholders) {
		this.policyholders = policyholders;
	}
	
}
