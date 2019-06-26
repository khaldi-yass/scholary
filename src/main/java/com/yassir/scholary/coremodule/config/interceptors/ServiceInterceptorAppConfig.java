package com.yassir.scholary.coremodule.config.interceptors;

import com.yassir.scholary.coremodule.interceptors.SimpleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ServiceInterceptorAppConfig implements WebMvcConfigurer {

    private SimpleInterceptor simpleInterceptor;

    @Autowired
    public ServiceInterceptorAppConfig(SimpleInterceptor simpleInterceptor) {
        this.simpleInterceptor = simpleInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleInterceptor);
    }
}
