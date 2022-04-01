package dima.salomakhin.task.javatesttaskv2.repo;

import dima.salomakhin.task.javatesttaskv2.entities.PairMongoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PairMongoRepository extends MongoRepository<PairMongoEntity, String> {
    PairMongoEntity findFirstBySymbol1AndSymbol2ContainingIgnoreCase(String symbol1, String symbol2);
}