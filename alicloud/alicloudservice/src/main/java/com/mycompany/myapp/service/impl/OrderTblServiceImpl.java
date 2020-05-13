package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.OrderTbl;
import com.mycompany.myapp.mapper.OrderTblMapper;
import com.mycompany.myapp.service.IOrderTblService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roger
 * @since 2020-05-13
 */
@Service
public class OrderTblServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl> implements IOrderTblService {

}
