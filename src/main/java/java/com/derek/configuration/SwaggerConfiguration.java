package java.com.derek.configuration;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public Docket myApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("java.com.derek"))
                .paths(regex("/rest.*"))
                .build();

    }
    private ApiInfo apiEndPointInfo(){
        return new ApiInfoBuilder().title("SPRING BOOT + REST + DATA JPA + JACKSON")
                .description()
                .contact(new Contact("Derek", "https://github.com/derekLisboa/CRUD-API-Springboot-oracle", "derekmlisboa@gmail.com"));
    }
}
