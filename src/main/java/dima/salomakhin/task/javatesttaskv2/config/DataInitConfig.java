package dima.salomakhin.task.javatesttaskv2.config;

import dima.salomakhin.task.javatesttaskv2.entities.PairMongoEntity;
import dima.salomakhin.task.javatesttaskv2.model.PairDto;
import dima.salomakhin.task.javatesttaskv2.repo.PairMongoRepository;
import dima.salomakhin.task.javatesttaskv2.services.CurrencyFetcherApiServiceClient;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true);
        return modelMapper;
    }

    @Bean
    public List<PairDto> init(ModelMapper modelMapper, PairMongoRepository pairMongoRepository, CurrencyFetcherApiServiceClient currencyFetcherApiServiceClient){
        List<PairDto> pairs = currencyFetcherApiServiceClient.getPairs();
        System.out.println(pairs);

        //mongo db
        List<PairMongoEntity> pairMongoEntities
                = modelMapper.map(pairs, new TypeToken<List<PairMongoEntity>>() {}.getType());
        pairMongoRepository.saveAll(pairMongoEntities);//todo convert from dto to entity;
        return pairs;
    }
}
