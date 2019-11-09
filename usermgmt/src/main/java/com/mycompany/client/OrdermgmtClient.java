package com.mycompany.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@AuthorizedFeignClient(name = "ordermgmt", fallback = OrdermgmtClientFallBack.class)
public interface OrdermgmtClient {

    /**
     * 获取服务名称
     *
     * @return
     */
    @RequestMapping(path = "/api/service/name", method = RequestMethod.GET)
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "corePoolSize", value = "10"), @HystrixProperty(name = "maximumPoolSize", value = "100"), @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"), @HystrixProperty(name = "keepAliveTime", value = "1"), @HystrixProperty(name = "maxQueueSize", value = "5")})
//    @CacheResult 默认情况下方法的所有参数都将作为缓存的key，如果传入的方法参数值相同，则去缓存值
    @CacheResult(cacheKeyMethod = "getCacheKey")
    //通过使用指定的方法来生成key
    String serviceName();

    default String getCacheKey(int value) {
        return String.valueOf(value);
    }

    /**
     * 获取服务详情
     *
     * @param serviceName
     * @param age
     * @return
     */
    @RequestMapping(path = "/api/service/info", method = RequestMethod.POST)
    @HystrixCommand
    @CacheResult
    String getServiceInfo(@RequestParam @CacheKey String serviceName, @RequestParam Integer age);

    /**
     * 调用此方法，可以让 getServiceInfo 方法的缓存失效
     *
     * @param serviceName 参数
     * @return
     */
    @CacheRemove(commandKey = "getServiceInfo")
    @HystrixCommand
    default String removeCache(@CacheKey String serviceName) {
        return null;
    }

}
