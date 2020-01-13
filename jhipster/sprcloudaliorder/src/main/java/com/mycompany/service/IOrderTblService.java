package com.mycompany.service;

import com.mycompany.domain.OrderTbl;

import io.seata.spring.annotation.GlobalTransactional;

import javax.transaction.Transactional;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author roger
 * @since 2019-12-30
 */
public interface IOrderTblService extends IService<OrderTbl> {
	
	@Transactional
	@GlobalTransactional
	public void globleSave(OrderTbl orderTbl);

}
