package com.mycompany.myapp.web.rest;


import com.mycompany.myapp.domain.OrderTbl;
import com.mycompany.myapp.service.IOrderTblService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author roger
 * @since 2020-05-13
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class OrderTblController {


    @Autowired
    private IOrderTblService orderTblService;

    @PostMapping(value = "/order")
    public String save(@RequestBody OrderTbl orderTbl){
      log.info("order = ",orderTbl);
      orderTblService.save(orderTbl);
      return orderTbl.toString();
    }
}

