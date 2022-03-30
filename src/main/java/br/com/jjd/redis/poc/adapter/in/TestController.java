package br.com.jjd.redis.poc.adapter.in;

import br.com.jjd.redis.poc.adapter.out.QueryImpl;
import br.com.jjd.redis.poc.application.dto.UserDetailsDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {
    private final QueryImpl query;

    @GetMapping("/test")
    UserDetailsDTO test(@RequestParam String name) {
        return query.query(name);
    }

}
