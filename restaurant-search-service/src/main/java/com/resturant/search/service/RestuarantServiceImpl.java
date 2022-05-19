package com.restuarant.search.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestuarantServiceImpl implements RestuarantService {

    private final RestuarantRepository restuarantRepository;
    private final CustomerRepository customerRepository;
    private final RestuarantMapper RestuarantrMapper;
    private final FoodOrderManager foodOrderManager;

    @Override
    List<Restuarant> listRestuarants(){
        return restuarantRepository.findAll();
    }

    @Override
    Restuarant getRestuarantByName(String name) throws RestuarantNotFoundException {
	Restuarant restuarant = restuarantRepository.findByRestuarantName();
	Objects.nonNull(restuarant) ? return restuarant : throw new RestuarantNotFoundException("restuarant for name :" + name + "not found");
    }

    @Override
    List<Restuarant> getRestuarantByLocation(String location) throws RestuarantNotFoundException {
	List<Restuarant> restuarantList = restuarantRepository.findByLocation();
	Objects.nonNull(restuarant) ? return restuarantList : throw new RestuarantNotFoundException("No restuarant in location:" + location + "found");
    
    }

    @Override
    List<Restuarant> getRestuarantByCuisine(String cuisine) throws RestuarantNotFoundException {
	List<Restuarant> restuarantList = restuarantRepository.findByCuisine();
	Objects.nonNull(restuarant) ? return restuarantList : throw new RestuarantNotFoundException("No restuarant for cuisine:" + cuisine + "found");
    
    }

    @Override
    Lis<Restuarant> getRestuarantByBudget(float budget) throws RestuarantNotFoundException {

    }

    @Override
    Menu getRestuarantMenu(Integer restuarantId) throws ProductNotFound {
	try{
	    Restuarant restuarant = restuarantRepository.findById(restuarantId);
	    return restuarant.getMenu();
	catch(Exception e){
	    throw new ProductNotFound(e.getMessage());
	}
    }
    
    @Override
    List<Order> getOrders(Integer restuarantId) throws OrderNotFound {
        Optional<FoodOrderLine> ordersList = restuarantRepository.findById(restuarantId);
        if(ordersList.isPresent()){
            return ordersList.get();
        }
        throw new OrderNotFound("Order Not Found for this restuarant");       
    }
}
