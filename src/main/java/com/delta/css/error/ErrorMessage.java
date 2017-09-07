package com.delta.css.error;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Error information
 * 
 */
public class ErrorMessage {

	@ApiModelProperty(position = 1, required = false, value = "")
	private String code;
	@ApiModelProperty(position = 2, required = false, value = "")
	private String message;
	@ApiModelProperty(position = 3, required = false, value = "")
	private String developerMessage;
	@ApiModelProperty(position = 4, required = false, value = "")
	private List<ErrorMoreInfo> moreInfo;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	public List<ErrorMoreInfo> getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(List<ErrorMoreInfo> moreInfo) {
		this.moreInfo = moreInfo;
	}

}