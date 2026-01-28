package com.example.work.adapter.in.controllers;

import com.example.work.application.ports.in.PriceServicePortIn;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PriceController {

    private final PriceServicePortIn priceServicePortIn;


    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

}
