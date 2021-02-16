package com.billennium.store.cart;

import com.billennium.store.item.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CartDto {

    Long id;
    List<ItemDto> orderItemsDto;
    
    Double totalPrice;
}
