package com.mycompany.web.rest;

import com.mycompany.proto.dto.TestReply;
import com.mycompany.proto.dto.TestRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InfoController {

    @RequestMapping(value = "/service/name", method = RequestMethod.GET)
    public String getServiceName(){
        return "this is ordermgmt info";
    }

    @GetMapping("/info")
    public TestReply getInfo(@RequestBody TestRequest testRequest){
        String name = testRequest.getName();
        TestReply reply = TestReply.newBuilder().setAge(10).setName(name +" roger").build();
        return reply;
    }

}
