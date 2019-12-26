package com.mycompany.service.impl;

import com.mycompany.domain.MyOrder;
import com.mycompany.mapper.MyOrderMapper;
import com.mycompany.service.IMyOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roger
 * @since 2019-11-22
 */
@Service
public class MyOrderServiceImpl extends ServiceImpl<MyOrderMapper, MyOrder> implements IMyOrderService {

}
