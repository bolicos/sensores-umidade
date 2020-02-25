package greenhouse.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "sensors")
@NoArgsConstructor
@Getter
public class Sensor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @OneToMany(fetch = FetchType.EAGER)
    @Transient
    private Set<Read> reads;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;
}
