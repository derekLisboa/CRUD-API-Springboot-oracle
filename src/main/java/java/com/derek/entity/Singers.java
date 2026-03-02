package java.com.derek.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@Entity
@Data
@NoArgsConstructor
public class Singers {

    @Id
    @Column(length = 15)
    @GeneratedValue
    private Integer Position;

    @Column(length = 15)
    private String name;

    @Column(length = 15)
    private Double Remuneration;

}
