package com.yassir.scholary.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface RootController {

    public String rootPath();
}
