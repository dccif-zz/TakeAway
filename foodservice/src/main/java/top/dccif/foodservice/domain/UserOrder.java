package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Shop.class)
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id", nullable = false)
    private Shop shop;
}
