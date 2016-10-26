package com.antra.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersVO {

	private RestResponse RestResponse;

	@JsonProperty(value="RestResponse")
	public RestResponse getRestResponse() {
		return RestResponse;
	}

	public void setRestResponse(RestResponse RestResponse) {
		this.RestResponse = RestResponse;
	}

	@Override
	public String toString() {
		return "UsersVO:[RestResponse:" + RestResponse + "]";
	}
}
