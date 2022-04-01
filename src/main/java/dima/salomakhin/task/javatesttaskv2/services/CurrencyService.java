package dima.salomakhin.task.javatesttaskv2.services;

import dima.salomakhin.task.javatesttaskv2.entities.PairMongoEntity;
import dima.salomakhin.task.javatesttaskv2.model.PairDto;
import dima.salomakhin.task.javatesttaskv2.repo.PairMongoRepository;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CurrencyService {

    @Autowired
    private PairMongoRepository pairMongoRepository;
    @Autowired
    private ModelMapper modelMapper;


    @SneakyThrows
    public List<PairDto> getAllPairs() {
        List<PairMongoEntity> pairMongoRepositoryAll = pairMongoRepository.findAll();
        List<PairDto> pairDtos
                = modelMapper.map(pairMongoRepositoryAll, new TypeToken<List<PairDto>>() {}.getType());
        return pairDtos;
    }

    @SneakyThrows
    public List<PairDto> getAllPairs(int page, int size) {
        Page<PairMongoEntity> all = pairMongoRepository.findAll(PageRequest.of(page, size));
        List<PairDto> pairDtos
                = modelMapper.map(all.getContent(), new TypeToken<List<PairDto>>() {}.getType());
        return pairDtos;
    }

    @SneakyThrows
    public PairDto getCurrency(String symbol1, String symbol2) {
        PairMongoEntity pairMongoEntity = pairMongoRepository.findFirstBySymbol1AndSymbol2ContainingIgnoreCase(symbol1, symbol2);
        PairDto  pairDto
                = modelMapper.map(pairMongoEntity,PairDto.class);
        return pairDto;
    }
}
