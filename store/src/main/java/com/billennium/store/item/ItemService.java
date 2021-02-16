package com.billennium.store.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream()
            .map(item -> modelMapper.map(item, ItemDto.class))
            .collect(Collectors.toList());
    }

    public ItemDto getItem(long id) {
        return modelMapper.map(itemRepository.findById(id).orElse(new Item()), ItemDto.class);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
