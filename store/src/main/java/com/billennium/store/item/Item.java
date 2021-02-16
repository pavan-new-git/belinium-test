package com.billennium.store.item;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    private int count = 0;

    @Column
    private BigDecimal price = ZERO;
}
