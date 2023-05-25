package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.MyCollectors;
import org.springframework.http.ResponseEntity;

public interface MyCollectorsService {
    void createMyCollectors(MyCollectors myCollectors);

    Iterable<MyCollectors> getMyCollectors();

    ResponseEntity deleteMyCollectors(int id);

    ResponseEntity updateMyCollectors(int id, MyCollectors myCollectors);
}
