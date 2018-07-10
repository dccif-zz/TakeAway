package top.dccif.foodservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SendWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 32)
    private String name;

    private String comment;
}
