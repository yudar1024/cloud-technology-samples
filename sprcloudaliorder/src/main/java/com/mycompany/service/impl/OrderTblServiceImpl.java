package com.mycompany.service.impl;

import com.mycompany.domain.OrderTbl;
import com.mycompany.mapper.OrderTblMapper;
import com.mycompany.service.IOrderTblService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roger
 * @since 2019-12-30
 */
@Service
public class OrderTblServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl> implements IOrderTblService {

	@Override
	public void globleSave(OrderTbl orderTbl) {
		// TODO Auto-generated method stub
		super.save(orderTbl);
	}
	

}
