package com.capstone.kuhako.controllers.ResellersControllers;

import com.capstone.kuhako.models.ResellerModule.SoldItems;
import com.capstone.kuhako.services.ResellerServices.SoldItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @CrossOrigin
    public class SoldItemsController {
        @Autowired
        SoldItemsService soldItemsService;

        @RequestMapping(value="/soldItems", method = RequestMethod.POST)
        public ResponseEntity<Object> createSoldItems(@RequestBody SoldItems soldItems) {
            soldItemsService.createSoldItems(soldItems);
            return new ResponseEntity<>("SoldItems created successfully", HttpStatus.CREATED);
        }

        @RequestMapping(value="/soldItems", method = RequestMethod.GET)
        public ResponseEntity<Object> getSoldItems() {
            return new ResponseEntity<>(soldItemsService.getSoldItems(), HttpStatus.OK);
        }

        @RequestMapping(value = "/soldItems/{soldItemsid}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> deleteSoldItems(@PathVariable Long soldItemsid) {
            return soldItemsService.deleteSoldItems(soldItemsid);
        }

        @RequestMapping(value="/soldItems/{soldItemsid}", method = RequestMethod.PUT)
        public ResponseEntity<Object> updateSoldItems(@PathVariable Long soldItemsid, @RequestBody SoldItems soldItems) {
            return soldItemsService.updateSoldItems(soldItemsid, soldItems);
        }
    }

