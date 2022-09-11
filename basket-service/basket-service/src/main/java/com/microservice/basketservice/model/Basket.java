package  com.microservice.basketservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name ="baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;

    @ManyToMany(cascade =  CascadeType.ALL)
    private List<Item> items;

    public Basket(){}
    public Basket(Long userId){
        this.userId = userId;
    }

}
