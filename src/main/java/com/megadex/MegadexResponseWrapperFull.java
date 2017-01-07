package com.megadex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;
@ResponseBody
public class MegadexResponseWrapperFull implements IMegadexResponseWrapper {

	private List<MegadexPolicyResponse> policies = new ArrayList<MegadexPolicyResponse>();
		public List<MegadexPolicyResponse> getPolicies() {
		return policies;
	}

	public void setPolicies(List<MegadexPolicyResponse> policies) {
		this.policies = policies;
	}

}
