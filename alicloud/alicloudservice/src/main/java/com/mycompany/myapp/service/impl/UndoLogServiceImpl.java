package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.UndoLog;
import com.mycompany.myapp.mapper.UndoLogMapper;
import com.mycompany.myapp.service.IUndoLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roger
 * @since 2020-06-03
 */
@Service
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLog> implements IUndoLogService {

}
