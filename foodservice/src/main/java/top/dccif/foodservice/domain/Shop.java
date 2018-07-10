package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Shop implements Serializable {

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 64)
    private String name;

    private Integer rank;

    private Timestamp dealTime;

    private String notice;

    @OneToMany(mappedBy = "shop")
    private Set<ShopKind> shopKinds = new HashSet<>();

    @OneToMany(targetEntity = Food.class)
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Set<Food> foods = new HashSet<>();

    @OneToMany(targetEntity = UserOrder.class, mappedBy = "shop")
    private Set<UserOrder> orders = new HashSet<>();
}
