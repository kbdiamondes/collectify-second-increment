package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.CollectorRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CollectorServiceImpl implements CollectorService{
    @Autowired
    private CollectorRepository collectorRepository;
    @Autowired
    private ResellerRepository resellerRepository;

    // Create a Collector
    @Override
    public void createCollector(Long resellerId, Collector collector) {
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);

        if (reseller != null) {
            collector.setReseller(reseller);
            collectorRepository.save(collector);
        }
    }

    // Get all Collector
    public Iterable<Collector> getUsername(){
        return collectorRepository.findAll();
    }
    // Delete Collector

    public ResponseEntity deleteCollector(Long id){
        collectorRepository.deleteById(id);
        return new ResponseEntity<>("Collector Deleted successfully", HttpStatus.OK);
    }
    public ResponseEntity updateCollector(Long id, Collector collector){
        // Find the user to update
        Collector collectorForUpdate = collectorRepository.findById(id).get();
        // Updating the username and password
        collectorForUpdate .setFullName(collector.getFullName());
        collectorForUpdate .setAddress(collector.getAddress());
        // Saving and Updating a user
        collectorRepository.save(collectorForUpdate );
        return new ResponseEntity<>("Collector updated Successfully",HttpStatus.OK);
    }
}
