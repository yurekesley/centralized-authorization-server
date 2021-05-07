package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.exception;

/**
 * @author yure.placido
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -7009754827505831074L;
	private Object[] params;
	private String code;
	private boolean messageComplete;

	public BusinessException(String code, Object... params) {
		this.code = code;
		this.params = params;
	}

	public BusinessException(String code, boolean messageComplete, Object... params) {
		this.code = code;
		this.params = params;
		this.messageComplete = messageComplete;
	}

	public String getCode() {
		return code;
	}

	public Object[] getParams() {
		return params;
	}

	public boolean isMessageComplete() {
		return messageComplete;
	}
}
