package com.mashup.pixtus.pixtus.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "올바르지 않은 계정입니다.")
public class UnauthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5412856433567779043L;

	public UnauthorizedException() {
		super("올바르지 않은 계정입니다.");
	}

}
