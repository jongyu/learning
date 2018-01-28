## SpringRedis

### Use technology
* RESTful
* SpringMVC
* Spring Data Redis
* MyBatis
* Druid
* Bootstrap-Table
* jQuery

### CN
* Spring整合Redis进行缓存
* 使用Spring Data Redis注解管理缓存

### EN
* Spring integrates Redis to cache
* Use the Spring Data Redis annotation to manage the cache

### Config
* applicationContext.xml
```xml
<bean id="poolConfig" class="redis.clients.jedis.JedisPoolConfig">
    <property name="maxIdle" value="${redis.maxIdle}"/>
    <property name="maxTotal" value="${redis.maxActive}"/>
    <property name="maxWaitMillis" value="${redis.maxWait}"/>
    <property name="testOnBorrow" value="${redis.testOnBorrow}"/>
</bean>

<bean id="jedisConnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
    <property name="hostName" value="${redis.host}"/>
    <property name="port" value="${redis.port}"/>
    <property name="password" value="${redis.pass}"/>
    <property name="database" value="${redis.dbIndex}"/>
    <property name="poolConfig" ref="poolConfig"/>
</bean>

<bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate">
    <property name="connectionFactory" ref="jedisConnectionFactory"/>
</bean>

<bean id="redisCacheManager" class="org.springframework.data.redis.cache.RedisCacheManager">
    <constructor-arg name="redisOperations" ref="redisTemplate"/>
    <property name="defaultExpiration" value="${redis.expiration}"/>
</bean>

<bean id="redisCacheConfig" class="com.zhongyu.common.redis.RedisCacheConfig">
    <constructor-arg ref="jedisConnectionFactory"/>
    <constructor-arg ref="redisTemplate"/>
    <constructor-arg ref="redisCacheManager"/>
</bean>
```
* JavaConfig
```java
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * Created by ZhongYu on 4/18/2017.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    private volatile JedisConnectionFactory jedisConnectionFactory;
    private volatile RedisTemplate<String, String> redisTemplate;
    private volatile RedisCacheManager redisCacheManager;

    public RedisCacheConfig() {
        super();
    }

    public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String,String> redisTemplate, RedisCacheManager redisCacheManager) {
        super();
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.redisTemplate = redisTemplate;
        this.redisCacheManager = redisCacheManager;
    }

    public JedisConnectionFactory redisConnectionFactory() {
        return jedisConnectionFactory;
    }

    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        return redisTemplate;
    }

    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        return redisCacheManager;
    }

    @Bean
    public KeyGenerator customKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
}
```
* USE
```java
import com.zhongyu.bean.Example;
import com.zhongyu.common.bean.Pager;
import com.zhongyu.dao.ExampleDao;
import com.zhongyu.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhongYu on 4/18/2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleDao exampleDao;

    @Override
    @Cacheable(value = "pagerExample", keyGenerator = "customKeyGenerator")
    public List<Example> examplePager(Pager pager) {
        return exampleDao.examplePager(pager);
    }

    @Override
    @Cacheable(value = "getExample", keyGenerator = "customKeyGenerator")
    public Example getExample(Integer id) {
        return exampleDao.getExample(id);
    }

    @Override
    @CacheEvict(value = {"saveExample", "countExample"}, allEntries = true)
    public Integer saveExample(Example example) {
        return exampleDao.insertExample(example);
    }

    @Override
    @CacheEvict(value = {"pagerExample", "countExample", "getExample"}, allEntries = true)
    public Integer updateExample(Example example) {
        return exampleDao.updateExample(example);
    }

    @Override
    @CacheEvict(value = {"pagerExample", "countExample", "getExample"}, allEntries = true)
    public Integer removeExample(Integer id) {
        return exampleDao.deleteExample(id);
    }

    @Override
    @Cacheable(value = "countExample", keyGenerator = "customKeyGenerator")
    public Integer countExample() {
        return exampleDao.countExample();
    }
}
```
