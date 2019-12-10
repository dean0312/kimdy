package net.plang.DYAccountVer3;

import javax.servlet.Filter;
import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import net.plang.DYAccountVer3.common.config.SiteMeshFilter;
import net.plang.DYAccountVer3.common.controller.SessionController;

@SpringBootApplication
public class DYAccountVer3Application{

   public static void main(String[] args) {
      SpringApplication.run(DYAccountVer3Application.class, args);
   }
   
   @Bean
   public FilterRegistrationBean<Filter> siteMeshFilter() {
      FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
      filter.setFilter(new SiteMeshFilter());
      return filter;
   }
   
    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
        return new ServletListenerRegistrationBean<HttpSessionListener>(new SessionController());   
    }
    @Bean
    public FilterRegistrationBean encodingFilterBean() {
   
    	FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    	CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
    	characterEncodingFilter.setForceEncoding(true);
    	characterEncodingFilter.setEncoding("UTF-8");
    	registrationBean.setFilter(characterEncodingFilter);
    	return registrationBean;
    	
    }
    
}