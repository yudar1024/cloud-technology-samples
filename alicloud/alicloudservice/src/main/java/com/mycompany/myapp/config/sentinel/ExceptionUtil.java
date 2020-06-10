package com.mycompany.myapp.config.sentinel;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;


public class ExceptionUtil {

	public static SentinelClientHttpResponse handleException(HttpRequest request,
                                                             byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
		System.out.println("Oops: " + ex.getClass().getCanonicalName());
		return new SentinelClientHttpResponse("custom block info");
	}

}
