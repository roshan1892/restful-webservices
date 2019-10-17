package com.roshanweb.restfulwebservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * SwaggerConfig for configuring Swagger2 to document RESTful web services in our application
 *
 * @author RoshanBhandari
 * @version 1.0.0
 * @since 2 Sep 2019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  public static final Contact DEFAULT_CONTACT = new Contact("The PlaySoft", "https://www.theplaysoft.com", "support@theplaysoft.com");
  private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation", "Api Documentation of the application", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
  private static final Set<String> DEFAULT_PRODUCES_AND_CONNSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_PRODUCES_AND_CONNSUMES)
            .consumes(DEFAULT_PRODUCES_AND_CONNSUMES);
  }
}
