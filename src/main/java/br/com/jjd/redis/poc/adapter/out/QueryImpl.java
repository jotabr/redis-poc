package br.com.jjd.redis.poc.adapter.out;

import br.com.jjd.redis.poc.adapter.out.mapper.UserDetailsDTOMapper;
import br.com.jjd.redis.poc.adapter.out.payload.ResponsePayload;
import br.com.jjd.redis.poc.application.dto.UserDetailsDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class QueryImpl {
    private final MyFeignConnector myFeignConnector;
    private final UserDetailsDTOMapper mapper;

    @SneakyThrows
    @Cacheable(cacheNames = "redis-poc")
    public UserDetailsDTO query(String name) {
        ResponsePayload responsePayload = myFeignConnector.getDetails(name);

        return mapper.toDTO(responsePayload);
    }
}
