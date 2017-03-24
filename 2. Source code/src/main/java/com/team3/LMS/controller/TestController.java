package com.team3.LMS.controller;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.LMS.dto.UserInfo;

@Controller
@RequestMapping
public class TestController {
	
	 @RequestMapping("test")
	    public ResponseEntity<String> handleRequest (RequestEntity<String> requestEntity) {
	        System.out.println("request body : " + requestEntity.getBody());
	        HttpHeaders headers = requestEntity.getHeaders();
	        System.out.println("request headers : " + headers);
	        HttpMethod method = requestEntity.getMethod();
	        System.out.println("request method : " + method);
	        System.out.println("request url: " + requestEntity.getUrl());

	        ResponseEntity<String> responseEntity = new ResponseEntity<>("my response body",
	                                                                     HttpStatus.OK);
	        return responseEntity;
	    }
	 @RequestMapping("/user")
	    public ResponseEntity<String> handleUserRequest (RequestEntity<UserInfo> requestEntity) {
	        UserInfo user = requestEntity.getBody();
	        System.out.println("request body: " + user);
	        System.out.println("request headers " + requestEntity.getHeaders());
	        System.out.println("request method : " + requestEntity.getMethod());

	        MultiValueMap<String, String> headers = new HttpHeaders();
	        headers.put("Cache-Control", Arrays.asList("max-age=3600"));

	        ResponseEntity<String> responseEntity = new ResponseEntity<>("my response body",
	                                                                     headers,
	                                                                     HttpStatus.OK);
	        return responseEntity;
	    }
}
