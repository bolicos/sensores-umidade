package greenhouse.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import greenhouse.security.AuthenticateService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticateService user;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/welcome", "/registration", "/resources/**", "/webjars/**", "/h2/**", "/admin/**")
				.permitAll().antMatchers(HttpMethod.POST, "/plants/read").permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").permitAll().and().logout().logoutSuccessUrl("/login?logout")
				.permitAll().and().rememberMe().userDetailsService(user);
		http.csrf().ignoringAntMatchers("/h2/**");
        //this will allow frames with same origin which is much more safe
        http.headers().frameOptions().sameOrigin();
	}

}