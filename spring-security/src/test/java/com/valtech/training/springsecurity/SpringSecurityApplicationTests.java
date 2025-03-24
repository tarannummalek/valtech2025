package com.valtech.training.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
//	@Test
//	public void testGetUser() throws Exception {
//		mockMvc.perform(get("/api/v1/users/2")).andDo(print())
//		.andExpect(content().json("{'id':2,'name':'abc','age':34,'email':'abc@gmail.com','isKid':false,'subId':2}"))
//		.andExpect(status().isOk());
//		
//	}
	@Test
	public void testGetUserByInvalidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/10")).andDo(print())
		.andExpect(status().isNotFound());
		
	}

}
