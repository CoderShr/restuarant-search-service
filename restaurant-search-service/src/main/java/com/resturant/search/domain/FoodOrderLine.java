
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
public class FoodOrderLine extends BaseEntity {


    @Builder
    public FoodOrderLine(Integer id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                         FoodOrder foodOrder, Integer foodId, Integer orderQuantity) {
        super(id, version, createdDate, lastModifiedDate);
        this.foodOrder = foodOrder;
	this.orderQuantity = orderQuantity;
        this.foodId = foodId;
    }

    private Integer foodId;

    private Integer orderQuantity;

    @ManyToOne
    private FoodOrder foodOrder;

}