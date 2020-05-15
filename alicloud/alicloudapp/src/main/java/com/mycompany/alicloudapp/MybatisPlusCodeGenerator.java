package com.mycompany.alicloudapp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MybatisPlusCodeGenerator {

    public static final boolean CREATE_MAPPER=true;
    public static final boolean CREATE_SERVICE=false;
    public static final boolean CREATE_CONTROLER=false;
    public static final boolean CREATE_ENTITY=true;

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "\\alicloudapp\\src\\main\\java");
        globalConfig.setAuthor("roger");
        globalConfig.setOpen(true);
        globalConfig.setEnableCache(true);
        globalConfig.setSwagger2(true);
        globalConfig.setFileOverride(true);

        mpg.setGlobalConfig(globalConfig);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/seata_storage?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dsc.setSchemaName("seata_storage");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("openstack");
        mpg.setDataSource(dsc);


        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.mycompany.alicloudapp");
        pc.setController("web.rest");
        pc.setEntity("domain");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);

        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude("storage_tbl","undo_log");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                if(fileType==FileType.ENTITY && CREATE_ENTITY){
                    return true;
                }
                if(fileType==FileType.MAPPER && CREATE_MAPPER){
                    return true;
                }
                if(fileType==FileType.XML && CREATE_MAPPER){
                    return true;
                }
                if(fileType==FileType.SERVICE && CREATE_SERVICE){
                    return true;
                }
                if(fileType==FileType.SERVICE_IMPL && CREATE_SERVICE){
                    return true;
                }
                if(fileType==FileType.CONTROLLER && CREATE_CONTROLER){
                    return true;
                }
                if(fileType==FileType.OTHER){
                    return true;
                }

                return false;
            }
        });
        mpg.setCfg(injectionConfig);
        mpg.execute();


    }
}
