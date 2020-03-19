package com.mycompany.storage.service.impl;

import com.mycompany.storage.domain.UndoLog;
import com.mycompany.storage.mapper.UndoLogMapper;
import com.mycompany.storage.service.IUndoLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roger
 * @since 2019-12-31
 */
@Service
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLog> implements IUndoLogService {

}
