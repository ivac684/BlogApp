package com.blog.app.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import com.blog.app.services.MyUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	private MyUserService myUserService;
	
	
public WebSecurityConfig(MyUserService myUserService) {

		this.myUserService = myUserService;
	}
    @Bean
    DaoAuthenticationProvider authProvider() {
    	
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setUserDetailsService(myUserService);
    	return provider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
    	
    	auth.authenticationProvider(authProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers(
                        "/",
                        "/**",
                        "/error/**",
                        "/users/register",
                        "/listPosts",
                        "/js/**",
                        "/css/**",
                        "/posts/create",
                        "/login",
                        "/img/**").permitAll();
         http
         		.csrf().disable().cors().disable()
                .formLogin()
    			.loginPage("/login")
    			.defaultSuccessUrl("/",true)
    			.permitAll()
    			.and()
    			.logout()
    			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    			.logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
    			.and()
    			.rememberMe();
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine() {
      SpringTemplateEngine engine  =  new SpringTemplateEngine();
      engine.addDialect( new SpringSecurityDialect() );
      return engine;
    }
}