package br.com.jjd.redis.poc.adapter.out.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResponsePayload {
    private String name;
    private Integer age;
    private Integer count;
}
