
package com.restuarant.search.repository;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerOrderLineRepository extends JPARepository<Food, Integer> {
}
