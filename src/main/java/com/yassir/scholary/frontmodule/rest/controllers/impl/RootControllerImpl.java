package com.yassir.scholary.frontmodule.rest.controllers.impl;

import com.yassir.scholary.frontmodule.rest.controllers.RootController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RootControllerImpl implements RootController {

    @Override
    @GetMapping("")
    public String rootPath() {
        return "<h1>Hello World</h1>";
    }
}
