package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorMessageDto implements Serializable {

	private static final long serialVersionUID = -6592820867624875778L;

	private String code;
	private Integer status;
	private String message;
	private String field;
	private Object[] params;

	public ErrorMessageDto() {

	}

	public ErrorMessageDto(String codeProperties) {
		this.code = codeProperties;
	}

	public ErrorMessageDto(String codeProperties, Object... params) {
		super();
		this.code = codeProperties;
		this.params = params;
	}

	public ErrorMessageDto(String message, String field) {
		super();
		this.message = message;
		this.field = field;
	}

	public ErrorMessageDto(String code, Integer status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public ErrorMessageDto(String code, Integer status, String message, Object... params) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.params = params;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object[] getParams() {
		return params;
	}
}
