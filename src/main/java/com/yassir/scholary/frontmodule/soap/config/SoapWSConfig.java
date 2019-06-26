package com.yassir.scholary.frontmodule.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWSConfig extends WsConfigurerAdapter {

    private static final String USER_XSD_PATH = "frontmodule/soap/UsersSchema.xsd";
    public static final String USER_TNS = "http://scholary.yassir.com/frontmodule/soap/userSchema";
    private static String URL_PATTERN = "/ws/*";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, URL_PATTERN);
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema imagesCHQXsd) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("userWSPort");
        definition.setTargetNamespace(USER_TNS);
        definition.setLocationUri("/ws");
        definition.setSchema(imagesCHQXsd);
        return definition;
    }

    @Bean
    public XsdSchema userXSD() {
        return new SimpleXsdSchema(new ClassPathResource(USER_XSD_PATH));
    }
}
