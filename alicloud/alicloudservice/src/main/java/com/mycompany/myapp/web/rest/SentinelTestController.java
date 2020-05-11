package com.mycompany.myapp.web.rest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class SentinelTestController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/hello")
	@SentinelResource("alicloudservice-resource")
	public String hello() {
		return "Hello";
	}

	@GetMapping(value = "/bb")
//	@SentinelResource("bb")
	public String aa(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
		return "alicloud service app test"+a+b;
	}

	@GetMapping(value = "/test")
	public String test1() {
		return "Hello test";
	}

	@GetMapping(value = "/template")
	public String client() {
		return restTemplate.getForObject("http://www.taobao.com/test", String.class);
	}

	@GetMapping(value = "/feign")
    public String feign(){
	    return "cloud service feign response";
    }
}
