package com.billennium.store.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> getItems() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemDto getItem(@PathVariable(name = "id") long id) {
        return itemService.getItem(id);
    }

}
