package dima.salomakhin.task.javatesttaskv2.services;

import dima.salomakhin.task.javatesttaskv2.model.PairData;
import dima.salomakhin.task.javatesttaskv2.repo.PairMongoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import dima.salomakhin.task.javatesttaskv2.model.PairDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@Component
@ConfigurationProperties(prefix = "service.host", ignoreUnknownFields = true)
public class CurrencyFetcherApiServiceClient {

    private String serviceHost = "https://cex.io/api/currency_limits";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    @SneakyThrows
    public List<PairDto> getPairs() {
        ResponseEntity<Map> response = restTemplate.exchange(
                serviceHost,
                HttpMethod.GET,
                null,
                Map.class);

        PairData data = objectMapper.readValue(objectMapper.writeValueAsString(response.getBody().get("data")), PairData.class);
        return data.getPairs();
    }

    public void setServiceHost(String serviceHost) {
        this.serviceHost = serviceHost;
    }
}
