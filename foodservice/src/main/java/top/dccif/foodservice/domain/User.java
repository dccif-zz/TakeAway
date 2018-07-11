package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 32, unique = true)
    private String username;

    @Column(length = 64)
    private String password;

    @Column(length = 32)
    private String nickname;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(length = 16)
    private String mobile;

    @Column(length = 64)
    private String email;

    private String avatarUrl;

    @OneToMany(targetEntity = Address.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Set<Address> address = new HashSet<>();

    @OneToMany(targetEntity = UserOrder.class, mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<UserOrder> orders = new HashSet<>();
}
