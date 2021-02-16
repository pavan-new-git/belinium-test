package com.billennium.store.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billennium.store.item.Item;
import com.billennium.store.item.ItemDto;
import com.billennium.store.item.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    
    private final ItemService itemService;

    @GetMapping
    public List<Cart> getCarts() {
        return cartService.findAll();
    }
    
    @PostMapping("/addItemToCart")
    public Boolean addItemToCart(@RequestBody ProductDto product) {

    	return cartService.addItemToCart(product);
    	
        
    }
    @GetMapping("/viewCart")
    public CartDto showCart(@RequestBody ProductDto product) {
    	
    	CartDto cart=cartService.findById(product.getCartId());
    	if(cart!=null && cart.getId()!=null) {
    		List<ItemDto> orderItemsDto=cart.getOrderItemsDto();
    		Double totalPrice=orderItemsDto.stream().filter(item->item.getPrice().doubleValue() > 0).mapToDouble(item->item.getPrice().doubleValue()).sum();
    		
    		cart.setTotalPrice(totalPrice);
    	}
    	
    	return cart;
        
    }
    
  
}
