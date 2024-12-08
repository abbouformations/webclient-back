package ma.formations.spring.rest.dao;

import ma.formations.spring.rest.model.Emp;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmpRepository extends ReactiveCrudRepository<Emp, Long> {
    Flux<Emp> findByNameContaining(String name);

    Flux<Emp> findBySalaireBetween(Double min, Double max);
}
