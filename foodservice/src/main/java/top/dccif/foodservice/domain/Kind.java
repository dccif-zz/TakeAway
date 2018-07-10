package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Kind implements Serializable {
    @Id
    @Column(name = "kind_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "kind")
    private Set<ShopKind> shopKinds = new HashSet<>();

    private String name;

}
