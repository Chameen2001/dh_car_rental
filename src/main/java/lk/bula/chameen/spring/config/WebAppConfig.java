package lk.bula.chameen.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.bula.chameen.spring")
@EnableWebMvc
public class WebAppConfig {
}
