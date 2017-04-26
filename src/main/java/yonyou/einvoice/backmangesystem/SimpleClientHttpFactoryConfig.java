package yonyou.einvoice.backmangesystem;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xinggq on 17-4-24.
 *
 * RestTemplate配置类
 */

@Configuration
public class SimpleClientHttpFactoryConfig {

    /**
     *
     *  获取SimpleClientHttpRequestFactory实例
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "rest.connection")
    public SimpleClientHttpRequestFactory configRequestFactory() {
        return new SimpleClientHttpRequestFactory();
    }


    /**
     * 获取RestTemplate实例
     * @return
     */
    @Bean
    public RestTemplate customRestTemplate(){
        return new RestTemplate(configRequestFactory());
    }
}
