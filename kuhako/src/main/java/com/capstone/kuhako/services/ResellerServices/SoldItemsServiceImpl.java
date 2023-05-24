package com.capstone.kuhako.services.ResellerServices;

import com.capstone.kuhako.models.ResellerModule.SoldItems;
import com.capstone.kuhako.repositories.ResellerRepositories.SoldItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SoldItemsServiceImpl implements SoldItemsService{
    @Autowired
    private SoldItemsRepository soldItemsRepository;

    public void createSoldItems(SoldItems soldItems){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        SoldItems newSoldItems = new SoldItems();
        newSoldItems.setItemName(soldItems.getItemName());
        newSoldItems.setStockQuantity(soldItems.getStockQuantity());
        soldItemsRepository.save(newSoldItems);
    }
    public Iterable<SoldItems> getSoldItems(){
        return soldItemsRepository.findAll();
    }

    public ResponseEntity deleteSoldItems(Long id){
        soldItemsRepository.deleteById(id);
        return new ResponseEntity<>("SoldItems Deleted successfully", HttpStatus.OK);


    }

    public ResponseEntity updateSoldItems(Long id, SoldItems soldItems){
        SoldItems soldItemsForUpdate = soldItemsRepository.findById(id).get();

        soldItemsForUpdate.setItemName(soldItems.getItemName());
        soldItemsForUpdate.setStockQuantity(soldItems.getStockQuantity());

        soldItemsRepository.save(soldItemsForUpdate);

        return new ResponseEntity("SoldItems updated successfully", HttpStatus.OK);

    }
}

