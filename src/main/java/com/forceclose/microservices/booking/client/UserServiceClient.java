package com.forceclose.microservices.booking.client;

import com.forceclose.microservices.booking.client.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users", url = "${app.users.client.url}", path = "/users")
public interface UserServiceClient {

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") String id);
}
