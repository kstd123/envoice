package yonyou.einvoice.backmangesystem.companyManagement.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class WebGlobalConfig {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		
		return new EmbeddedServletContainerCustomizer(){

			public void customize(ConfigurableEmbeddedServletContainer container) {
				// TODO Auto-generated method stub
				container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500"));
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/400"));
			}
			
		};
	}
}
