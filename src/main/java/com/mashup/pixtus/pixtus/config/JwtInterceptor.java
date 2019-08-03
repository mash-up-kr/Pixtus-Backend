package com.mashup.pixtus.pixtus.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mashup.pixtus.pixtus.jwt.JwtService;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtService jwtService;

	private static final String HEADER_AUTH = "Authorization";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String token = request.getHeader(HEADER_AUTH);

		if (token != null && jwtService.isUsable(token))
			return true;

		return false;
	}

}
