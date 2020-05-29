package br.com.martins.cep_api;

import br.com.martins.cep_api.configuration.DataSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE, classes = {DataSourceConfiguration.class}))
public class ApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiApplication.class, args);

    }

}
