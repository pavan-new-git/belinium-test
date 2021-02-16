package com.billennium.store.cart;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.billennium.store.item.Item;
import com.billennium.store.item.ItemDto;
import com.billennium.store.item.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    
    private final ItemService itemService;

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
    
    public CartDto findById(Long id) {
        return modelMapper.map(cartRepository.findById(id).orElse(new Cart()), CartDto.class);
    }

    public Cart createOrUpdate(Cart cart) {
        return cartRepository.saveAndFlush(cart);
    }
    
    
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Boolean addItemToCart(ProductDto product) {
		CartDto cart = findById(product.getCartId());
		ItemDto item = itemService.getItem(product.getItemId());
		Cart cartObj =null;
		try {
			if (item != null && item.getCount() > 0) {
				Item itemObj = modelMapper.map(item, Item.class);
				itemObj.setCount(itemObj.getCount() - 1);
				itemObj = itemService.save(itemObj);
				if (cart == null ||cart.getId()==null ) {
					 cartObj = new Cart();
					cartObj.setId(product.getCartId());

				} else {
					cartObj=modelMapper.map(cart, Cart.class);
				}
				List<Item> items = new ArrayList<>();
				items.add(itemObj);
				cartObj.setOrderItems(items);
				createOrUpdate(cartObj);
			} else {
				throw new RuntimeException("Item not found");
			}

		} catch (Exception e) {

			throw new RuntimeException("Error in adding the item in cart");
		}
		return true;
	}
   
}
