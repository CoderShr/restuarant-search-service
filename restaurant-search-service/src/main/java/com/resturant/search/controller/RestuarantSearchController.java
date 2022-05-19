package com.restuarant.search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/search/")
@RestController
public class RestuarantSearchController {

    private final RestuarantService restuarantService ;

    public BeerOrderController(RestuarantService restuarantService) {
        restuarantService = restuarantService;
    }

    @GetMapping("resturants")
    public ResponseEntity<List<Restuarant>> listRestuarants()  throws RestuarantNotFoundException {
	List<Restuarant> restuarantList = restuarantService.listRestuarants()
        return new ResponseBody<List<Restuarant>>(restuarantList, HttpStatus.Ok);
    }

    @GetMapping("resturantByName/{restuarantName}")
    public ResponseEntity<Restuarant> showRestuarantByName(@PathVariable String restuarantName) throws RestuarantNotFoundException {
	Restuarant restuarant = restuarantService.getRestuarantByName(restuarantName);
        return new ResponseBody<Restuarant>(restuarant, HttpStatus.Ok);
    }

    @GetMapping("restuarantByLocation/{location}")
    public ResponseEntity<List<Restuarant>> showRestuarantByLocation(@PathVariable String location) throws RestuarantNotFoundException {
	List<Restuarant> restuarants = restuarantService.getRestuarantByLocation(location);
        return new ResponseBody<Restuarant>(restuarants, HttpStatus.Ok);
    }

    @GetMapping("restuarantByCuisine/{cuisine}")
    public ResponseEntity<List<Restuarant>> showRestuarantByLocation(@PathVariable String cuisine) throws RestuarantNotFoundException {
	Restuarant restuarants = restuarantService.getRestuarantByCuisine(cuisine);
        return new ResponseBodyList<<Restuarant>>(restuarants, HttpStatus.Ok);
    }

    @GetMapping("restuarantMenu/{id}")
    public ResponseEntity<Menu> showRestuarantMenu(@PathVariable Integer id)throws ProductNotFound {
	Restuarant restuarant = restuarantService.getRestuarantMenu(id);
        return new ResponseBody<Menu>(restuarant, HttpStatus.Ok);
    }

    @GetMapping("restuarantByBudget/{budget}")
    public ResponseEntity<List<Restuarant>> showRestuarantByBudget(@PathVariable String budget) throws RestuarantNotFoundException {
	Restuarant restuarant = restuarantService.getRestuarantByBudget(budget);
        return new ResponseBodyList<<Restuarant>>(restuarant, HttpStatus.Ok);
    }

    @GetMapping("getRestuarantOrders/{id}")
    public ResponseEntity<List<Restuarant>> showRestuarantOrders(@PathVariable String id) throws OrderNotFoundException {
	List<Order> orders = restuarantService.getOrders(id);
        return new ResponseBodyList<Order>>(orders, HttpStatus.Ok);
    }

}
