package com.mycompany.web.rest;


import com.mycompany.domain.OrderTbl;
import com.mycompany.service.IOrderTblService;
import com.mycompany.service.impl.OrderTblServiceImpl;
import io.swagger.annotations.ApiOperation;
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
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/api/order-tbl")
@Slf4j
public class OrderTblController {

    @Autowired
    private IOrderTblService iOrderTblService;

    @PostMapping("/order")
    @ApiOperation("下单")
    public void saveOrder(@RequestBody OrderTbl orderTbl){
        iOrderTblService.save(orderTbl);
    }
    
    @PostMapping("/gloable/order")
    @ApiOperation("下单-分布式事务")
    public void globleSave() {
		log.info("分布式事务下单");
	}

}

