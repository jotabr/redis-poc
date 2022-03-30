package br.com.jjd.redis.poc.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserDetailsDTO implements Serializable {
    private static final long serialversionuid = 1L;

    private String name;
    private Integer age;
    private Integer count;
}
