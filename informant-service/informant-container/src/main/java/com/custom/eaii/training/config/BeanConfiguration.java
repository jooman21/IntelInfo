package com.custom.eaii.training.config;

import com.custom.eaii.training.IntelInfoDomainService;
import com.custom.eaii.training.IntelInfoDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
  public IntelInfoDomainService intelInfoDomainService(){
      return  new IntelInfoDomainServiceImpl();
  }
}
