package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.SoldItems;
import org.springframework.http.ResponseEntity;

public interface SoldItemsService {
    void createSoldItems(SoldItems soldItems);

    Iterable<SoldItems> getSoldItems();

    ResponseEntity deleteSoldItems(Long id);

    ResponseEntity updateSoldItems(Long id, SoldItems soldItems);
}

