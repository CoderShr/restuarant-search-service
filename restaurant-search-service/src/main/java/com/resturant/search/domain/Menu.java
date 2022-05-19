
packagecom.restuarant.search.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuId;

   // @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
  //  @Fetch(FetchMode.JOIN)
  //  private List<Food> foodList;



    /**
     * The name of the dish (String) for this menu item
     */
    @Column(nullable = false)
    private String dish;

    /**
     * The cost (float) of this menu item
     */
    private float price;

    /**
     * The restaurant to which this menu item is associated
     */
    @ManyToOne
    @JoinColumn(name = "restaurantid",
        nullable = false)
    @JsonIgnoreProperties(value = "menu",
        allowSetters = true)
    private Restaurant restaurant;

}
