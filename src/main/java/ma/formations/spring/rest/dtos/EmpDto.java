package ma.formations.spring.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpDto {
    private Long id;
    private String name;
    private String fonction;
    private Double salaire;
}
