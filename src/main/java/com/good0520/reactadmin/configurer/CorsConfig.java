package com.good0520.reactadmin.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Good0520
 * @date 2019/9/23
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许任何域名
        corsConfiguration.addAllowedOrigin("*");
        //允许任何头
        corsConfiguration.addAllowedHeader("*");
        //允许任何方法
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //注册
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
