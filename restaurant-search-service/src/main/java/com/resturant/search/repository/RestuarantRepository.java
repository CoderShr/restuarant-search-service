
package com.restuarant.search.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestuarantRepository  extends JpaRepository<Restuarant, Integer> {

    Restuarant findAllByRestuarantName(String name);

    List<Restuarant> findAllByCuisine(String Cuisine);

    List<Restuarant> findAllByRestuarantName(String name);

    List<Restuarant> findAllByLocation(String location);

}
