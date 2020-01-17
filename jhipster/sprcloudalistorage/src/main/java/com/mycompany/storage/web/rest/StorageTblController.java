package com.mycompany.storage.web.rest;


import com.mycompany.storage.domain.StorageTbl;
import com.mycompany.storage.service.IStorageTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author roger
 * @since 2019-12-31
 */
@RestController
@RequestMapping("/api/")
public class StorageTblController {

    @Autowired
    private IStorageTblService storageTblService;

    @PostMapping("/storage")
    public void save(@RequestBody StorageTbl storageTbl){
        storageTblService.save(storageTbl);
    }

}

