package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

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

    @ManyToOne(targetEntity = SendWorker.class)
    @JoinColumn(name = "send_worker_id", referencedColumnName = "id", nullable = false)
    private SendWorker sendWorker;

    @OneToMany(targetEntity = Food.class)
    @JoinColumn(name = "user_order_id", referencedColumnName = "id")
    private List<Food> foods = new LinkedList<>();
}
