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

    private String comment;
}
