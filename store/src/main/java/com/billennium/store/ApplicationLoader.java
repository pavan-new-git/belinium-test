package com.billennium.store;

import com.billennium.store.item.Item;
import com.billennium.store.item.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Component
public class ApplicationLoader implements ApplicationRunner {

    private final ItemService itemService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application Loader starts his job.");
        itemService.save(buildItem("PC", BigDecimal.valueOf(100), 5));
        itemService.save(buildItem("Keyboard", BigDecimal.valueOf(15), 20));
        itemService.save(buildItem("Camera", BigDecimal.valueOf(24), 0));
        itemService.save(buildItem("Mouse", BigDecimal.valueOf(3), 13));
        log.info("Application Loader finish his job.");
    }

    private Item buildItem(String name, BigDecimal price, int count) {
        return Item.builder()
                .name(name)
                .price(price)
                .count(count)
                .build();
    }
}
