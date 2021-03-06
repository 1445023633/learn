package com.changlan.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**跨域问题**/
@Configuration
public class CORSConfiguration extends WebMvcConfigurerAdapter{
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(5000);
        super.addCorsMappings(registry);
    }
    
}