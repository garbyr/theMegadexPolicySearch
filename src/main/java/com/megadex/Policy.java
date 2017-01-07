package com.megadex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Policy {
	private String policy;
	private String searchyStuff;
	private String transactionTimeStamp;
	private String effectiveFromStamp;
	private String status;
	private String sourceApplication;
	private String sourceURI;
	private String sourceTransactionType;
	private List<String> policyholders;
			
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	
	public String getSearchyStuff() {
		return searchyStuff;
	}
	public void setSearchyStuff(String searchyStuff) {
		this.searchyStuff = searchyStuff;
	}
	
	public String getTransactionTimeStamp() {
		return transactionTimeStamp;
	}
	public void setTransactionTimeStamp(String transactionTimeStamp) {
		this.transactionTimeStamp = transactionTimeStamp;
	}
	public String getEffectiveFromStamp() {
		return effectiveFromStamp;
	}
	public void setEffectiveFromStamp(String effectiveFromStamp) {
		this.effectiveFromStamp = effectiveFromStamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSourceApplication() {
		return sourceApplication;
	}
	public void setSourceApplication(String sourceApplication) {
		this.sourceApplication = sourceApplication;
	}
	public String getSourceTransactionType() {
		return sourceTransactionType;
	}
	public void setSourceTransactionType(String sourceTransactionType) {
		this.sourceTransactionType = sourceTransactionType;
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
	public boolean futureEffectiveDate() throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date tx;
        Date ef;
		try
        {
            tx = simpleDateFormat.parse(transactionTimeStamp);
            ef = simpleDateFormat.parse(effectiveFromStamp);
        }
        catch (ParseException ex)
        {
            throw new Exception(ex);
        }
        if (ef.after(tx)){
		return true;
        } else{
        	return false;
        }
	}
	public String getTransactionYear(){
		return transactionTimeStamp.substring(6,10);
	}
	
	public String generateTransactionKey(){
		return transactionTimeStamp.replaceAll("[^0-9]", "");
	}
}
