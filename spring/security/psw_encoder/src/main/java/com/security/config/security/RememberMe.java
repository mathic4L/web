package com.security.config.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RememberMe {

//    @Autowired(required = false)
//    private DataSource dataSource;

//    @Bean
//    public SecurityFilterChain mySecurityFilterChain(HttpSecurity http) throws Exception {
//        // http // дефолт
//        //          .passwordManagement(Customizer.withDefaults())
//        http
//                .rememberMe()
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(86400)
//        ;
//
//        return http.build();
//    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setDataSource(dataSource);
//        return tokenRepository;
//    }
}
