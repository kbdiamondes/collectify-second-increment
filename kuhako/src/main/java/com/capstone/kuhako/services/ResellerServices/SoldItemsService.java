package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.AssignCollectors;
import com.capstone.kuhako.models.ResellerModule.SoldItems;
import org.springframework.http.ResponseEntity;

public interface SoldItemsService {
    void createSoldItems(Long resellerId,SoldItems soldItems);

    Iterable<SoldItems> getSoldItems();

    Iterable<SoldItems>getSoldItemsByResellerId(Long resellerId);

    ResponseEntity deleteSoldItems(Long resellerId,Long id);

    ResponseEntity updateSoldItems(Long resellerId,Long id, SoldItems soldItems);
}

