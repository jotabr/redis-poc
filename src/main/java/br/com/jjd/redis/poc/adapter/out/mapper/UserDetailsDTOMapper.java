package br.com.jjd.redis.poc.adapter.out.mapper;

import br.com.jjd.redis.poc.adapter.out.payload.ResponsePayload;
import br.com.jjd.redis.poc.application.dto.UserDetailsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailsDTOMapper {
    UserDetailsDTO toDTO(ResponsePayload responsePayload);
}
