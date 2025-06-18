package org.example.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
public class ViewResolver {

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine());
        resolver.setCharacterEncoding("UTF-8");
//        resolver.s
        return resolver;
    }

    @Bean
    public springTemplateEngine() {
        return new SpringTemplateEngine();
    }

    // из алишева
//    public class SpringConfig implements WebMvcConfigurer {
//
//        private final ApplicationContext applicationContext;
//
//        @Autowired
//        public SpringConfig(ApplicationContext applicationContext) {
//            this.applicationContext = applicationContext;
//        }
//
//        @Bean
//        public SpringResourceTemplateResolver templateResolver() {
//            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//            templateResolver.setApplicationContext(applicationContext);
//            templateResolver.setPrefix("/WEB-INF/views/");
//            templateResolver.setSuffix(".html");
//            return templateResolver;
//        }
//
//        @Bean
//        public SpringTemplateEngine templateEngine() {
//            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//            templateEngine.setTemplateResolver(templateResolver());
//            templateEngine.setEnableSpringELCompiler(true);
//            return templateEngine;
//        }
//
//        @Override
//        public void configureViewResolvers(ViewResolverRegistry registry) {
//            ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//            resolver.setTemplateEngine(templateEngine());
//            registry.viewResolver(resolver);
//        }
//    }


}


