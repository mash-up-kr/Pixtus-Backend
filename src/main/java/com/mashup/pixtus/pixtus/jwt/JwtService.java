package com.mashup.pixtus.pixtus.jwt;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mashup.pixtus.pixtus.jwt.exception.UnauthorizedException;
import com.mashup.pixtus.pixtus.user.dto.ReqUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtService {
	
	private String secretKey;
	
	@Value("${jwt.secret-key}")
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	public String create(ReqUserDto requestBody) {
		Key key = Keys.hmacShaKeyFor(generateKey());
		
		String jws = Jwts.builder()
						.setHeaderParam("typ", "JWT")
						.setSubject("user")
						.claim("uid", requestBody.getUid())
						.signWith(key, SignatureAlgorithm.HS256)
						.compact();
		
		return jws;
	}
	
	public boolean isUsable(String jws) {
		log.info("jws : {} ", jws);
		getJwsClaims(jws);

		return true;
	}

	public Jws<Claims> getJwsClaims(String jws) {
		Jws<Claims> claims;
		try {
			 claims = Jwts.parser()
						.setSigningKey(generateKey())
						.parseClaimsJws(jws);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
		
		return claims;
	}
	
	public String getValue(String key) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		String jws = req.getHeader("Authorization");
		
		Jws<Claims> jwsClaims = getJwsClaims(jws);
		
		return jwsClaims.getBody().get(key).toString();
	}
	
	public String getUid() {
		return getValue("uid");
	}
	
	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = secretKey.getBytes("UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			log.debug("generate key fail : {} ", e);
//			e.printStackTrace();
		}

		return key;
	}

}
