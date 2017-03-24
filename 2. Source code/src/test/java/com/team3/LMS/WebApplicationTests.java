package com.team3.LMS;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class WebApplicationTests {
	@LocalServerPort
	int port;
	
	private TestRestTemplate template;
	 @Autowired
	    private WebApplicationContext wac;
	    private MockMvc mockMvc;

	    @Before
	    public void setup () {
	        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	        this.mockMvc = builder.build();
	    }

	    @Test
	    public void testTestController () throws Exception {
	        MockHttpServletRequestBuilder builder =
	                                      MockMvcRequestBuilders.post("/test")
	                                        .header("testHeader",
	                                                "headerValue")
	                                        .content("test body");
	        this.mockMvc.perform(builder)
	                    .andExpect(MockMvcResultMatchers.status()
	                                                    .isOk())
	                    .andDo(MockMvcResultHandlers.print());
	     }
	    @Test
	    public void testUserTestController () throws Exception {

	        MockHttpServletRequestBuilder builder =
	                                   MockMvcRequestBuilders.post("/user")
	                                        .header("testHeader",
	                                                "headerValue")
	                                        .contentType(MediaType.APPLICATION_JSON)
	                                        .content(createUserInJson("sample@csc.com",
	                                                            "123456"));
	        this.mockMvc.perform(builder)
	                    .andExpect(MockMvcResultMatchers.status()
	                                                    .isOk())
	                    .andDo(MockMvcResultHandlers.print());
	    }

	    private static String createUserInJson (String email, String password) {
	        return "{ \"email\": \"" + email + "\", " +
	                            "\"password\":\"" + password + "\"}";
	    }
}
