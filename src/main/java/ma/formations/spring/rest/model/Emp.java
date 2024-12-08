package ma.formations.spring.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("EMP")
public class Emp {
    @Id
    @Column("ID")
    private Long id;
    @Column("NAME")
    private String name;
    @Column("FONCTION")
    private String fonction;
    @Column("SALAIRE")
    private Double salaire;
}
