package colval.qc.ca.bird_project.Config;

import colval.qc.ca.bird_project.model.entities.User;
import colval.qc.ca.bird_project.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
                .antMatchers("/User/Create").permitAll()//accès au bloc customer
                .antMatchers("/User/save").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/css/main.css").permitAll()
                .anyRequest().authenticated()// pour toute autre requetes: doit être authentifié .authenticated
                .and() //fin de la configuration des ressources
                .formLogin() //connexion via un formulaire
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    //encryption du mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authentification de l'utilisateur
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}


