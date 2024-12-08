package ma.formations.spring.rest.controller;

import lombok.AllArgsConstructor;
import ma.formations.spring.rest.dtos.EmpDto;
import ma.formations.spring.rest.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@AllArgsConstructor
public class EmpController {
    private IService service;

    @GetMapping(value = "/employees/{id}")
    Mono<EmpDto> getEmployees(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/employees", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<EmpDto> getEmployees() {
        return service.findAll().delayElements(Duration.ofSeconds(1L));
    }


    @PostMapping(value = "/employees")
    Mono<EmpDto> createEmployee(@RequestBody EmpDto dto) {
        return service.save(dto);
    }

    @PutMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmpDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmpDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployees(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/employees")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllEmployees() {
        return service.deleteAll();
    }

    @GetMapping("/employees/salaire")
    public Flux<EmpDto> getEmployeesBySalaireBetween(@RequestParam Map<String, String> parameters) {
        Double min = Double.parseDouble(parameters.get("min"));
        Double max = Double.parseDouble(parameters.get("max"));
        return service.findBySalaireBetween(min, max);
    }

}

