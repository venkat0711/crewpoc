package com.delta.css.error;

import io.swagger.annotations.ApiModelProperty;

/**
 * More information about the error
 * 
 */
public class ErrorMoreInfo {
    @ApiModelProperty(position = 1, required = false, value = "")
    private String code;
    @ApiModelProperty(position = 2, required = false, value = "")
    private String description;
    @ApiModelProperty(position = 3, required = false, value = "")
    private String inputParam;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputParam() {
        return inputParam;
    }

    public void setInputParam(String inputParam) {
        this.inputParam = inputParam;
    }

}
