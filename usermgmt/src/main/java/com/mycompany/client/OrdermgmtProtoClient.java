package com.mycompany.client;

import com.mycompany.config.ProtoFeignConfiguration;
import com.mycompany.proto.dto.TestReply;
import com.mycompany.proto.dto.TestRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ordermgmt", configuration = ProtoFeignConfiguration.class)
@AuthorizedFeignClient
public interface OrdermgmtProtoClient {
    @GetMapping(path = "/api/info",  consumes = "application/x-protobuf", produces = "application/x-protobuf")
    public TestReply getInfo(@RequestBody TestRequest testRequest);

}
