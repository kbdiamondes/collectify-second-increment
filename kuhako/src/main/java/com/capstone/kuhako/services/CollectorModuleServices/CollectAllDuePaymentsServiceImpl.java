package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.CollectAllDuePayments;
import com.capstone.kuhako.repositories.CollectorModuleRepository.CollectAllDuePaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CollectAllDuePaymentsServiceImpl implements CollectAllDuePaymentsService {
    @Autowired
    private CollectAllDuePaymentsRepository collectAllDuePaymentsRepository;

//    @Autowired
//    CollectorRepository collectorRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createCollectAllDuePayments(CollectAllDuePayments collectAllDuePayments){
//        Collector author = collectorRepository.findByCollectorname(jwtToken.getCollectornameFromToken(stringToken));

        CollectAllDuePayments newCollectAllDuePayments = new CollectAllDuePayments();
        newCollectAllDuePayments.setCollector(collectAllDuePayments.getCollector());
        newCollectAllDuePayments.setCollectionDate(collectAllDuePayments.getCollectionDate());
        newCollectAllDuePayments.setRequiredCollectibles(collectAllDuePayments.getRequiredCollectibles());
        newCollectAllDuePayments.setItemCollectible(collectAllDuePayments.getItemCollectible());
        newCollectAllDuePayments.setTransactionProof(collectAllDuePayments.getTransactionProof());
        collectAllDuePaymentsRepository.save(newCollectAllDuePayments);
    }
    public Iterable<CollectAllDuePayments> getCollectAllDuePayments(){
        return collectAllDuePaymentsRepository.findAll();
    }

    public ResponseEntity deleteCollectAllDuePayments(Long id){
        collectAllDuePaymentsRepository.deleteById(id);
        return new ResponseEntity<>("CollectAllDuePayments Deleted successfully", HttpStatus.OK);

//        CollectAllDuePayments collectAllDuePaymentsForDeleting = collectAllDuePaymentsRepository.findById(id).get();
//        String collectAllDuePaymentsName = collectAllDuePaymentsForDeleting.getCollector().getCollectorname();
//        String authenticatedCollectorname = jwtToken.getCollectornameFromToken(stringToken);
//
//        if (authenticatedCollectorname.equals(collectAllDuePaymentsName)){
//            collectAllDuePaymentsRepository.deleteById(id);
//            return new ResponseEntity<>("CollectAllDuePayments Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this CollectAllDuePayments",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateCollectAllDuePayments(Long id, CollectAllDuePayments collectAllDuePayments){
        CollectAllDuePayments collectAllDuePaymentsForUpdate = collectAllDuePaymentsRepository.findById(id).get();

        collectAllDuePaymentsForUpdate.setCollector(collectAllDuePayments.getCollector());
        collectAllDuePaymentsForUpdate.setCollectionDate(collectAllDuePayments.getCollectionDate());
        collectAllDuePaymentsForUpdate.setRequiredCollectibles(collectAllDuePayments.getRequiredCollectibles());
        collectAllDuePaymentsForUpdate.setItemCollectible(collectAllDuePayments.getItemCollectible());
        collectAllDuePaymentsForUpdate.setTransactionProof(collectAllDuePayments.getTransactionProof());
        
        collectAllDuePaymentsRepository.save(collectAllDuePaymentsForUpdate);

        return new ResponseEntity("CollectAllDuePayments updated successfully", HttpStatus.OK);

//        CollectAllDuePayments collectAllDuePaymentsForUpdating = collectAllDuePaymentsRepository.findById(id).get();
//        String collectAllDuePaymentsName = collectAllDuePaymentsForUpdating.getCollector().getCollectorname();
//        String authenticatedCollectorName= jwtToken.getCollectornameFromToken(stringToken);
//
//        if(authenticatedCollectorName.equals(collectAllDuePaymentsName)){
//            collectAllDuePaymentsForUpdating.setName(collectAllDuePayments.getName());
//            collectAllDuePaymentsForUpdating.setDescription(collectAllDuePayments.getDescription());
//            collectAllDuePaymentsForUpdating.setPrice(collectAllDuePayments.getPrice());
//
//            collectAllDuePaymentsRepository.save(collectAllDuePaymentsForUpdating);
//            return  new ResponseEntity("CollectAllDuePayments has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("You are not authorize to update this CollectAllDuePayments.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
