package co.mz.cth.park.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class Security_cth extends  WebSecurityConfigurerAdapter{

@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.inMemoryAuthentication()
	 .withUser("me").password("{noop}123456789").roles("Register").and()
	 .withUser("you").password("{noop}123456789").roles("list");

}
	
@Override
public void configure(WebSecurity web) throws Exception {
	web.ignoring()
 	.antMatchers("i18n/**","css/**","js/**");
}


@Override
protected void configure(HttpSecurity http) throws Exception {
	 http
	 .authorizeRequests()
	  .antMatchers("/car","searchCar","register","search","parkRegister","searchParkers").hasRole("Register")
	   .anyRequest()
	    .authenticated()
	     .and().formLogin()
     .loginPage("/login")
	    .permitAll()
	    .and()
	 .logout()
	 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));      	  
	}
}
