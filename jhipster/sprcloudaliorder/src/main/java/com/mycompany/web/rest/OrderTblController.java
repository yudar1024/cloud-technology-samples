package com.mycompany.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mycompany.domain.OrderTbl;
import com.mycompany.service.IOrderTblService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author roger
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/api")
public class OrderTblController {
	
	@Autowired
	private IOrderTblService orderService;
	
	@PostMapping("/globale/order")
	public void globleSave(@RequestBody OrderTbl orderTbl) {
		orderService.globleSave(orderTbl);
	}

}

