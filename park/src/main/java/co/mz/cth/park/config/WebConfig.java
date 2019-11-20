package co.mz.cth.park.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	 
    public void addViewControllers(ViewControllerRegistry registry) {
	registry.addRedirectViewController("/", "/car");
	
	}
}
