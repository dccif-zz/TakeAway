package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity
public class ShopKind implements Serializable {
    @Id
    @ManyToOne(targetEntity = Shop.class)
    @JoinColumn(name = "Shop_id")
    private Shop shop;

    @Id
    @ManyToOne(targetEntity = Kind.class)
    @JoinColumn(name = "Kind_id")
    private Kind kind;

//    @Id
//    private Integer id;

//    @OneToMany(targetEntity = Food.class)
//    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
//    private Set<Food> foods = new HashSet<>();
}
