package com.task.bot.controller;

import com.task.bot.entites.Event;
import com.task.bot.service.VkApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/", produces = APPLICATION_JSON_VALUE)
public class VkApiController {

    private final VkApiService service;

    @PostMapping
    public String doResponse(@RequestBody Event event) {
        return service.doResponse(event);
    }
}
