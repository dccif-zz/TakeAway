package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Food implements Serializable {
    @Id
    @Column(name = "food_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String name;

    private Double price;

    private Integer remainder;

    private String comment;

    @OneToOne(targetEntity = Kind.class)
    @JoinColumn(name = "kind_id", referencedColumnName = "kind_id", unique = true)
    private Kind kind;
}
