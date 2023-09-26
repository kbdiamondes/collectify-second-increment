package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import com.capstone.kuhako.repositories.CollectorModuleRepository.CollectAllDuePaymentsRepository;
import com.capstone.kuhako.repositories.CollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CollectAllDuePaymentsServiceImpl implements CollectAllDuePaymentsService {
    @Autowired
    private CollectAllDuePaymentsRepository collectAllDuePaymentsRepository;
    @Autowired
    private CollectorRepository collectorRepository;

    public void createCollectAllDuePayments(Long collectorId, CollectAllDuePayments collectAllDuePayments){
        Collector collector = collectorRepository.findById(collectorId).orElse(null);
        if (collector != null) {
            collectAllDuePayments.setCollector(collector);
            collectAllDuePaymentsRepository.save(collectAllDuePayments);
        }
    }

    public Iterable<CollectAllDuePayments> getCollectAllDuePayments(){
        return collectAllDuePaymentsRepository.findAll();
    }

    public Iterable<CollectAllDuePayments> getCollectAllDuePaymentsByCollectorId(Long collectorId){
        return collectAllDuePaymentsRepository.findCollectAllDuePaymentsByCollectorId(collectorId);
    }

    public ResponseEntity deleteCollectAllDuePayments(Long collectorId, Long id){
        CollectAllDuePayments collectAllDuePaymentsToDelete = collectAllDuePaymentsRepository.findById(id).orElse(null);

        if (collectAllDuePaymentsToDelete != null && collectAllDuePaymentsToDelete.getCollector().getCollector_id().equals(collectorId)) {
            collectAllDuePaymentsRepository.deleteById(id);
            return new ResponseEntity<>("CollectAllDuePayments Deleted successfully", HttpStatus.OK);
        } else if (collectAllDuePaymentsToDelete != null) {
            return new ResponseEntity<>("CollectAllDuePayments does not belong to the specified collector", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("CollectAllDuePayments not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity updateCollectAllDuePayments(Long collectorId, Long id, CollectAllDuePayments collectAllDuePayments){
        CollectAllDuePayments collectAllDuePaymentsForUpdate = collectAllDuePaymentsRepository.findById(id).orElse(null);
        if (collectAllDuePaymentsForUpdate != null && collectAllDuePaymentsForUpdate.getCollector().getCollector_id().equals(collectorId)) {
            collectAllDuePaymentsForUpdate.setCollectionDate(collectAllDuePayments.getCollectionDate());
            collectAllDuePaymentsForUpdate.setRequiredCollectibles(collectAllDuePayments.getRequiredCollectibles());
            collectAllDuePaymentsForUpdate.setItemCollectible(collectAllDuePayments.getItemCollectible());
            collectAllDuePaymentsForUpdate.setTransactionProof(collectAllDuePayments.getTransactionProof());
            collectAllDuePaymentsRepository.save(collectAllDuePaymentsForUpdate);
            return new ResponseEntity<>("CollectAllDuePayments Updated successfully", HttpStatus.OK);
        } else if (collectAllDuePaymentsForUpdate != null) {
            return new ResponseEntity<>("CollectAllDuePayments does not belong to the specified collector", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("CollectAllDuePayments not found",HttpStatus.NOT_FOUND);
        }
    }
}
