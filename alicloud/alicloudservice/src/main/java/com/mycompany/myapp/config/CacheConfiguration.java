package com.mycompany.myapp.config;

import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.jhipster.config.cache.PrefixedKeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.redisson.jcache.configuration.RedissonConfiguration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import io.github.jhipster.config.JHipsterProperties;

@Configuration
@EnableCaching
public class CacheConfiguration {
    private GitProperties gitProperties;
    private BuildProperties buildProperties;

//    使用Redisson 作为redis 客户端
    @Bean
    public javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration(JHipsterProperties jHipsterProperties) {
        MutableConfiguration<Object, Object> jcacheConfig = new MutableConfiguration<>();
        Config config = new Config();
        if (jHipsterProperties.getCache().getRedis().isCluster()) {
            config.useClusterServers().addNodeAddress(jHipsterProperties.getCache().getRedis().getServer());
        } else {
            config.useSingleServer().setAddress(jHipsterProperties.getCache().getRedis().getServer()[0]);
        }
        jcacheConfig.setStatisticsEnabled(true);
        jcacheConfig.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS, jHipsterProperties.getCache().getRedis().getExpiration())));
        return RedissonConfiguration.fromInstance(Redisson.create(config), jcacheConfig);
    }


    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer(javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration,ApplicationProperties applicationProperties) {

        RedissonConfiguration configuration = (RedissonConfiguration) jcacheConfiguration;
        MutableConfiguration jcacheConfig = (MutableConfiguration)configuration.getJcacheConfig();

        Random random = new Random();
        final int duration = random.nextInt(applicationProperties.getCache().getMaxExpiration() - applicationProperties.getCache().getMinExpiration() + 1) + applicationProperties.getCache().getMinExpiration();
        jcacheConfig.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS,duration)));
        return cm -> {
            createCache(cm, "cm1", configuration);
            createCache(cm, "cm2", configuration);

        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName, javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache == null) {
            cm.createCache(cacheName, jcacheConfiguration);
        }
    }

    @Autowired(required = false)
    public void setGitProperties(GitProperties gitProperties) {
        this.gitProperties = gitProperties;
    }

    @Autowired(required = false)
    public void setBuildProperties(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new PrefixedKeyGenerator(this.gitProperties, this.buildProperties);
    }

}
