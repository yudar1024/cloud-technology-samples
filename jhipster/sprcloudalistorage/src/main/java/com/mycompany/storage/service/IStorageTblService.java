package com.mycompany.storage.service;

import com.mycompany.storage.domain.StorageTbl;
import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.spring.annotation.GlobalTransactional;

import javax.transaction.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author roger
 * @since 2019-12-31
 */
public interface IStorageTblService extends IService<StorageTbl> {

    @Transactional
    @GlobalTransactional
    void globalSave(StorageTbl storageTbl);

}
