
package com.restuarant.search.domain;

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

@Data
@Entity
@Table(name = "restuarant"
indexes = {
        @Index(name = "restaurantId_menuId", columnList = "menu_id", unique = true)
}
)
public class Restuarant {

    @Builder
    public Restuarant(Interger restaurantId, String restuarantName, 
			String location, Menu menu) {
	this.restaurantId = restaurantId;
        this.restuarantName = restuarantName;
      	this.location = location;
	this.menu = menu;
	this.address = restuarantName + "," + location;

	//this.foodOrders = foodOrders;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurantId;

    @Column(unique = true,
        nullable = false)
    private String restuarantName;

    private String location;

    private String address;

    @Size(min = 2,
        max = 2,
        message = "State is the two letter abbreviation")
    private String state;

    private String telephone;

    @JsonIgnore
    @OneToOne(targetEntity = Menu.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "restaurant", 
	targetEntity = Menu.class, fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties(value = "restaurant",
        allowSetters = true)
    @JoinColumn(nullable = false, name = "menu_id")
    private List<Menu> menus = new ArrayList<>();



  //  @OneToMany(mappedBy = "restuarant", cascade = CascadeType.ALL)
  //  @Fetch(FetchMode.JOIN)
 //   private List<FoodOrderLine> foodOrderLines;


    /**
     * Part of the join relationship between restaurants and payment types
     * connects restaurants to the restaurant payments combination
     */
    @OneToMany(mappedBy = "restaurant",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties(value = "restaurant",
        allowSetters = true)
    private Set<RestaurantPayments> payments = new HashSet<>();
}
