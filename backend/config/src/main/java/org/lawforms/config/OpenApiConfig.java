package org.lawforms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("LawForm API")
                        .version("V1")
                        .description("로폼 프로젝트 API TEST")
                        .termsOfService("http://localhost:8080/")
                        //.license(new License().name("라이센스 이름").url("라이센스 URL"))
                );
    }

}
