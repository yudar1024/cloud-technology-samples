package com.mycompany.service.impl;

import com.mycompany.domain.Databasechangelog;
import com.mycompany.mapper.DatabasechangelogMapper;
import com.mycompany.service.IDatabasechangelogService;
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
public class DatabasechangelogServiceImpl extends ServiceImpl<DatabasechangelogMapper, Databasechangelog> implements IDatabasechangelogService {

}
