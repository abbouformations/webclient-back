package ma.formations.spring.rest.service;

import ma.formations.spring.rest.dtos.EmpDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IService {
    public Flux<EmpDto> findAll();

    public Flux<EmpDto> findByNameContaining(String name);

    public Mono<EmpDto> findById(Long id);

    public Mono<EmpDto> save(EmpDto dto);

    public Mono<EmpDto> update(Long id, EmpDto dto);

    public Mono<Void> deleteById(Long id);

    public Mono<Void> deleteAll();

    public Flux<EmpDto> findBySalaireBetween(Double min, Double max);

}
