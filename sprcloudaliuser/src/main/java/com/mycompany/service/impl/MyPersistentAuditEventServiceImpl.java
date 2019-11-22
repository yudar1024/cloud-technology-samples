package com.mycompany.service.impl;

import com.mycompany.domain.MyPersistentAuditEvent;
import com.mycompany.mapper.MyPersistentAuditEventMapper;
import com.mycompany.service.IMyPersistentAuditEventService;
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
public class MyPersistentAuditEventServiceImpl extends ServiceImpl<MyPersistentAuditEventMapper, MyPersistentAuditEvent> implements IMyPersistentAuditEventService {

}
