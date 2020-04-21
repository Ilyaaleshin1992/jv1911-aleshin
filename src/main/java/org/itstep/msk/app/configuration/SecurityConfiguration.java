package org.itstep.msk.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.sql.DataSource;
import java.util.Objects;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    // Настройка БД для security
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Запрос пользователя для аутентификации
        String usersQuery = "SELECT username, password, 1 as active FROM users WHERE email = ?";
        // Запрос ролей пользователя для авторизации
        String authoritiesQuery =
                "SELECT u.username, ur.role "
                        + "FROM users u "
                        + "INNER JOIN user_roles ur ON ur.user_id = u.id "
                        + "WHERE u.username = ?";

        // Настраиваем аутентификацию и авторизацию через БД (JDBC)
        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(authoritiesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/login").permitAll()
//                .antMatchers("/admin/**").hasRole(Role.ROLE_ADMIN.name())
//                .antMatchers("/user/**").hasRole(Role.ROLE_USER.name())
//                .anyRequest().authenticated();
                .anyRequest().permitAll();

        http.csrf().disable();

        // Настройка формы логина
        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password");

        // Настройка разлогина
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");

    }
}
