package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    //Get
    @GetMapping("get")
    @PreAuthorize("hasAnyAuthority('READ')")
    public String helloGet() {
        return "Hello Get";
    }

    //Post
    @PostMapping("pots")
    public String hellopost() {
        return "Hello Post";
    }

    //Put
    @PutMapping("put")
    public String helloPut() {
        return "Hello Put";
    }

    //Delete
    @DeleteMapping("delete")
    public String helloDelete() {
        return "Hello Delete";
    }

}
