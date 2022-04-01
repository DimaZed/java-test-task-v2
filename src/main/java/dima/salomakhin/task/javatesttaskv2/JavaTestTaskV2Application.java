package dima.salomakhin.task.javatesttaskv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class JavaTestTaskV2Application {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters2 = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter2 = new MappingJackson2HttpMessageConverter();
        converter2.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters2.add(converter2);
        restTemplate.setMessageConverters(messageConverters2);

        return restTemplate;
    }

    public static void main(String[] args)  {

        SpringApplication.run(JavaTestTaskV2Application.class, args);

    }
}
