package br.com.jjd.redis.poc.adapter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;

@Slf4j
@EnableCaching
@Configuration
public class CacheConfiguration extends CachingConfigurerSupport {

    @Override
    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
                log.info("Falha na leitura do cache: " + cache.getName() + ", exception: " + exception.toString());
            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
                log.info("Falha na escrita do cache: " + cache.getName() + ", exception: " + exception.toString());
            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
                log.info("Falha ao despejar cache: " + cache.getName() + ", exception: " + exception.toString());
            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {
                log.info("Falha ao limpar cache: " + cache.getName() + ", exception: " + exception.toString());
            }
        };
    }

}
