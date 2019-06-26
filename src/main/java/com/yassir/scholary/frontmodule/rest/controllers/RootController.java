package com.yassir.scholary.frontmodule.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface RootController {

    public String rootPath();
}
