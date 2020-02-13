package com.davidarutiunian.springbootapp.infrastructure.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1.0/greeting")
class GreetingController {
    companion object {
        const val MODULE_NAME = "HR"
    }

    @GetMapping
    fun greet(@RequestParam(required = false) name: String?): String {
        return "Hello from <strong>$MODULE_NAME</strong>, dear ${name?.capitalize() ?: "<% username! %>"}!"
    }
}
