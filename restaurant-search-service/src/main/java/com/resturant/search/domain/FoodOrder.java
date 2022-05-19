
package com.restuarant.search.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FoodOrder extends BaseEntity {

    @Builder
    public FoodOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, Customer customer,
                     String customerRef, Customer customer,
                     Set<FoodOrderLine> foodOrderLines) {
        super(id, version, createdDate, lastModifiedDate);
        this.customer = customer;
        this.foodOrderLines = foodOrderLines;
    }

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "foodOrder", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<FoodOrderLine> foodOrderLines;
}
