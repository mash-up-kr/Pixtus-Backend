package com.mashup.pixtus.pixtus.jwt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mashup.pixtus.pixtus.jwt.exception.UnauthorizedException;
import com.mashup.pixtus.pixtus.user.dto.ReqUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class JwtServiceTest {

	private JwtService jwtService;
	
	private String jws;

	@Before
	public void init() {
		jwtService = new JwtService();
		jwtService.setSecretKey("pixtusProjectJwtServiceTestSecretKey");
		
		ReqUserDto requestBody = new ReqUserDto("1234", "ehdgus2398@gmail.com");
		jws = jwtService.create(requestBody);
	}

	@Test
	public void test_createAndGet() {
		Jws<Claims> jwsClaims = jwtService.getJwsClaims(jws);

		assertEquals("1234", jwsClaims.getBody().get("uid"));
	}
	
	@Test
	public void test_isUsable() {
		assertTrue(jwtService.isUsable(jws));
	}
	
	@Test(expected = UnauthorizedException.class)
	public void test_get_UnauthorizedException() {
		String testJws = "eyJ0eXAiOiJKV1QiLCJhbOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwidWlkIjoiMTIzNCIsImV4cFRpbWUiOjE1NjDU5MDB9.Q7NI7VF4z8JvsF4Gx4NaokzGsi7GpDG_8";
		
		jwtService.getJwsClaims(testJws);
	}

}
