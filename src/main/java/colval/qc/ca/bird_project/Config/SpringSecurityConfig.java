package colval.qc.ca.bird_project.Config;

import colval.qc.ca.bird_project.model.entities.User;
import colval.qc.ca.bird_project.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SpringSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/api/**").permitAll()// permet ces requête
                .antMatchers("/User/Create").permitAll()//accès au bloc customer
                .antMatchers("/User/save").permitAll()
                //.antMatchers("/assetslogin/**").permitAll()
                .anyRequest().authenticated()// pour toute autre requetes: doit être authentifié .authenticated
                .and() //fin de la configuration des ressources
                .formLogin() //connexion via un formulaire
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

                //.and()
                //.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        List<User> users = this.userService.readAll();
        for (User user : users){
            System.out.println(user);
            auth.inMemoryAuthentication()
                    .withUser(user.getUserName()).roles("USER").password("{noop}" + user.getPassword());
        }
        /*auth.inMemoryAuthentication()
                .withUser("user").roles("USER").password("{noop}temp123")
                .and()
                .withUser("admin").roles("ADMIN").password("{noop}admin");*/
    }
}


