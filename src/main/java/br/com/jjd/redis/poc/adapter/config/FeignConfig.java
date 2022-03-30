package br.com.jjd.redis.poc.adapter.config;

import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter()));
    }

    @Bean
    public Encoder feignEncoder() {
        return new FormEncoder(new SpringEncoder(feignHttpMessageConverter()));
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }

    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        return () -> new HttpMessageConverters(new GatewayMappingJackson2HttpMessageConverter());
    }

    public class GatewayMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        GatewayMappingJackson2HttpMessageConverter() {
            setSupportedMediaTypes(List.of(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + "; charset=UTF-8")));
        }
    }

}
