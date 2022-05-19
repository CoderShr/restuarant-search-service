
package com.restuarant.search.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class Food{

    @Builder
    public Food(Integer id, String foodName, String cuisine, String description, 
		float price) {
        this.id = id;
        this.foodName = foodName;
	thsi.description = description;
        this.price = price;
	this.cuisine = cuisine;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String foodName;

    private String cuisine;

    private String description; 

    private float price;
}
