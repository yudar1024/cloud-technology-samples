package com.mycompany.alicloudapp.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mycompany.alicloudapp.feign.AliCloudServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SentinelTestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AliCloudServiceFeignClient aliCloudServiceFeignClient;

	@GetMapping(value = "/hello")
	@SentinelResource("resource")
	public String hello() {
		return "Hello";
	}

	@GetMapping(value = "/aa")
	@SentinelResource(value = "aa", blockHandler = "aaHandler")
	public String aa(int b, int a) {
		return "Hello test";
	}


	public String aaHandler(int b, int a, BlockException be) {
		return "Hello test 限流";
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
	public String feign(int a, int b){
		String result = aliCloudServiceFeignClient.aa(a,b);
		return result;
	}
}
