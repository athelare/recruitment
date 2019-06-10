package com.ctl.recruitment;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.cors.CorsConfiguration.ALL;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    public static final String URL_PATH = "/file/";
    public static String DISK_PATH;
    public static String HOST;

    static {
        String os = System.getProperties().getProperty("os.name");
        if (os != null && os.toLowerCase().contains("linux")){
            DISK_PATH="/usr/lijiyu/webFile/";
            HOST="http://139.224.134.84:8080";
        }else{
            DISK_PATH="D:/webFile/";
            HOST="http://localhost:8080";
        }
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 图片传路径 */
        registry.addResourceHandler(URL_PATH+"*").addResourceLocations("file:"+DISK_PATH);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(ALL)
                .allowedMethods(ALL)
                .allowedHeaders(ALL)
                .allowCredentials(true);
    }
}
