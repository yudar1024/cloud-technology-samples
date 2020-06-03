package com.mycompany.alicloudapp.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "alicloudservice", fallback = AliCloudServiceFeignClient.ServiceFallBack.class,configuration = AliCloudServiceFeignClient.AlicloudServiceAppFeignConfiguration.class )
//@FeignClient(value = "alicloudservice")
public interface AliCloudServiceFeignClient {
//   这里会新建一个sentinel资源， name = GET:http://alicloudservice/api/bb
    @GetMapping(value = "/api/bb")
    public String aa(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b);


    public class AlicloudServiceAppFeignConfiguration {

        @Bean
        public ServiceFallBack getFallBack(){
            return new ServiceFallBack();
        }
    }

    public class ServiceFallBack implements AliCloudServiceFeignClient {
        @Override
        public String aa(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
            return "a= "+a+" b= "+b +"限流结果";
        }
    }
}
