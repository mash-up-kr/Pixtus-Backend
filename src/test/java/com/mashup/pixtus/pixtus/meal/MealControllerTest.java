package com.mashup.pixtus.pixtus.meal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashup.pixtus.pixtus.meal.dto.ReqMealDto;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = { MealController.class, MealService.class })
@WebMvcTest(MealController.class)
//@EnableAutoConfiguration(exclude = WebConfig.class)
//@OverrideAutoConfiguration(enabled=true)
public class MealControllerTest {

	@Autowired
	private MockMvc mockMvc;

//	@MockBean
//	private JwtService jwtService;

//	@MockBean
//	private JwtInterceptor jwtInterceptor;

	private ReqMealDto requestBody;

	private ObjectMapper objectMapper;

	@Before
	public void setup() {
		requestBody = new ReqMealDto();
		requestBody.setSelectedB(true);
		requestBody.setSelectedD(true);
		requestBody.setSelectedL(true);
		requestBody.setSelectedM(true);

		objectMapper = new ObjectMapper();
	}

	@Test
	public void test() throws JsonProcessingException, Exception {

//		mockMvc.perform(post("/meal").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
//				.content(objectMapper.writeValueAsString(requestBody))).andExpect(status().isOk()).andDo(print());
	}

}
