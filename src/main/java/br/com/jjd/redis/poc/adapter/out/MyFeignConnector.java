package br.com.jjd.redis.poc.adapter.out;

import br.com.jjd.redis.poc.adapter.config.FeignConfig;
import br.com.jjd.redis.poc.adapter.out.payload.ResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "agify", url = "https://api.agify.io", configuration = FeignConfig.class)
public interface MyFeignConnector {

    @GetMapping
    ResponsePayload getDetails(@RequestParam String name);

}
