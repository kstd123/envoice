package yonyou.einvoice.backmangesystem.companyManagement.config;

import org.quartz.impl.JobDetailImpl;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class BeanConfig {

	 @Autowired(required = false)
	 JobFactory jobFactory;
	 
	 /**
	  * 注册调度器
	  * @return
	  */
	 @Bean
	 public SchedulerFactoryBean createSchedulerFactoryBean() {
	      SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
	      schedulerFactoryBean.setJobFactory(jobFactory);
	      return schedulerFactoryBean;
	 }
	 
	 @Bean
	 public JobDetailImpl createJobDetailImpl() {
	        return new JobDetailImpl();
	    }
	
	 
}
