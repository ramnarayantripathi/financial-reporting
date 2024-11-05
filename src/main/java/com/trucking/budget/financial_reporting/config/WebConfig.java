package com.trucking.budget.financial_reporting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * Configuration class for Web MVC settings.
 * This class is used to configure Cross-Origin Resource Sharing (CORS) settings.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /***
     * Configures CORS mappings for the application.
     * This method allows requests from specified origins and configures allowed methods and headers.
     *
     * @param registry the CorsRegistry to configure
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // registry.addMapping("/api/**") // Adjust this to your API path
        registry.addMapping("/api/financial-reports/**") //*** Specifies the API path for financial reports. ***
                .allowedOrigins("http://localhost:3000") //*** Adjust this to your frontend URL. ***
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //*** Allowed HTTP methods for CORS requests. ***
                .allowedHeaders("*") //*** Allows all headers in CORS requests. ***
                .allowCredentials(true); //*** Indicates whether credentials (like cookies) are allowed. ***
    }
}
