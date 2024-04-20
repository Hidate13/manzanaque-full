package com.educlaas.helpdesk.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.educlaas.helpdesk.jwtsecurity.TokenAuthenticationFilter;
import com.educlaas.helpdesk.service.UsersServiceImpl;

@Configuration
//use to enable configure class
@EnableWebSecurity
//use to enable Web Security
@EnableGlobalMethodSecurity(
      securedEnabled = true,
      //security for controller, service method
      jsr250Enabled = true,
      //@RolesAllowed annotation
      prePostEnabled = true
      //PreAuthorize or PostAuthorize
)

public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UsersServiceImpl usersServiceImpl;
  
  @Bean
  public TokenAuthenticationFilter tokenAuthenticationFilter() {
      return new TokenAuthenticationFilter();
  }

  //AuthenticationManagerBuidler - is used to create AuthenticationManager
  //AuthenticationManagerBuilder - is used to build custom authentication, JDBC, etc
  //In my project, want to authenticate usersServiceImpl and passwordEncoder
  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
      authenticationManagerBuilder
              .userDetailsService(usersServiceImpl)
      				.passwordEncoder(NoOpPasswordEncoder.getInstance());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
	  return NoOpPasswordEncoder.getInstance();
//      return new BCryptPasswordEncoder();
  }


  @Bean(BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }



  
  protected void configure(HttpSecurity http) throws Exception {
      http
              .cors()
                  .and()
              .sessionManagement()
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                  .and()
              .csrf()
                  .disable()
              .formLogin()
                  .disable()
              .httpBasic()
                  .disable()                    
              .authorizeRequests()
                  .antMatchers("/",
                      "/error",
                      "/favicon.ico",
                      "/**/*.png",
                      "/**/*.gif",
                      "/**/*.svg",
                      "/**/*.jpg",
                      "/**/*.html",
                      "/**/*.css",
                      "/**/*.js")
                      .permitAll()
                  .antMatchers("/api/**")
                      .permitAll()
                  .antMatchers("/profile",
                		  "/ticket","/updateSpecialist")
                      .authenticated()
                  .anyRequest()
                      .authenticated();
               

      // Add our custom Token based authentication filter
      http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }
}
