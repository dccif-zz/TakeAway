package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Address implements Serializable {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String detail;

}
