package com.billennium.store.item;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ItemDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private int count ;
}
