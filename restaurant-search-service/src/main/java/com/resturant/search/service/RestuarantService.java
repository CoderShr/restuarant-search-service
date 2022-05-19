package com.restuarant.search.service;


@Service
public interface RestuarantService {

    List<Restuarant> listRestuarants() throws RestuarantNotFoundException;

    List<Restuarant> getRestuarantByName(String name) throws RestuarantNotFoundException;

    List<Restuarant> getRestuarantByLocation(String location) throws RestuarantNotFoundException;

    List<Restuarant> getRestuarantByCuisine(String cuisine) throws RestuarantNotFoundException;

    Restuarant getRestuarantByBudget(float budget) throws RestuarantNotFoundException;

    Restuarant getRestuarantByDistance(Integer distance) throws RestuarantNotFoundException;

    Restuarant getRestuarantMenu(Integer restuarantId) throws ProductNotFound;
    
    List<Order> getOrders(Integer restuarantId) throws OrderNotFound;
}
