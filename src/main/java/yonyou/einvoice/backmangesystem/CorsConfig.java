package yonyou.einvoice.backmangesystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by xinggq on 17-4-1.
 *
 * 解决跨域
 */

/**
 * @Configuration注解用于类，用来表示把该类作为spring配置文件中的一个bean
 */
@Configuration
public class CorsConfig {


    /**
     * CORS配置容器
     * @return
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * 返回一个CROS过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //登记一个路径和一个CORS容器，
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
