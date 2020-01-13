package com.mycompany.service.impl;

import com.mycompany.domain.MyPersistentAuditEvtData;
import com.mycompany.mapper.MyPersistentAuditEvtDataMapper;
import com.mycompany.service.IMyPersistentAuditEvtDataService;
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
public class MyPersistentAuditEvtDataServiceImpl extends ServiceImpl<MyPersistentAuditEvtDataMapper, MyPersistentAuditEvtData> implements IMyPersistentAuditEvtDataService {

}
