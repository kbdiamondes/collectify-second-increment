package com.capstone.kuhako.services.CollectorModuleServices;


import com.capstone.kuhako.models.CollectorModules.CollectPayments;
import com.capstone.kuhako.repositories.CollectorModuleRepository.CollectPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class CollectPaymentsServiceImpl implements CollectPaymentsService{
    @Autowired
    private CollectPaymentsRepository collectPaymentsRepository;

//    @Autowired
//    CollectorRepository collectorRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createCollectPayments(CollectPayments collectPayments){
//        Collector author = collectorRepository.findByCollectorname(jwtToken.getCollectornameFromToken(stringToken));

        CollectPayments newCollectPayments = new CollectPayments();
        newCollectPayments.setCollector(collectPayments.getCollector());
        newCollectPayments.setCollectionDate(collectPayments.getCollectionDate());
        newCollectPayments.setRequiredCollectibles(collectPayments.getRequiredCollectibles());
        newCollectPayments.setItemCollectible(collectPayments.getItemCollectible());
        newCollectPayments.setPaymentType(collectPayments.getPaymentType());
        newCollectPayments.setTransactionProof(collectPayments.getTransactionProof());
        collectPaymentsRepository.save(newCollectPayments);
    }
    public Iterable<CollectPayments> getCollectPayments(){
        return collectPaymentsRepository.findAll();
    }

    public ResponseEntity deleteCollectPayments(Long id){
        collectPaymentsRepository.deleteById(id);
        return new ResponseEntity<>("CollectPayments Deleted successfully", HttpStatus.OK);

//        CollectPayments collectPaymentsForDeleting = collectPaymentsRepository.findById(id).get();
//        String collectPaymentsName = collectPaymentsForDeleting.getCollector().getCollectorname();
//        String authenticatedCollectorname = jwtToken.getCollectornameFromToken(stringToken);
//
//        if (authenticatedCollectorname.equals(collectPaymentsName)){
//            collectPaymentsRepository.deleteById(id);
//            return new ResponseEntity<>("CollectPayments Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this CollectPayments",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateCollectPayments(Long id, CollectPayments collectPayments){
        CollectPayments collectPaymentsForUpdate = collectPaymentsRepository.findById(id).get();

        collectPaymentsForUpdate.setCollector(collectPayments.getCollector());
        collectPaymentsForUpdate.setCollectionDate(collectPayments.getCollectionDate());
        collectPaymentsForUpdate.setRequiredCollectibles(collectPayments.getRequiredCollectibles());
        collectPaymentsForUpdate.setItemCollectible(collectPayments.getItemCollectible());
        collectPaymentsForUpdate.setPaymentType(collectPayments.getPaymentType());
        collectPaymentsForUpdate.setTransactionProof(collectPayments.getTransactionProof());

        collectPaymentsRepository.save(collectPaymentsForUpdate);

        return new ResponseEntity("CollectPayments updated successfully", HttpStatus.OK);

//        CollectPayments collectPaymentsForUpdating = collectPaymentsRepository.findById(id).get();
//        String collectPaymentsName = collectPaymentsForUpdating.getCollector().getCollectorname();
//        String authenticatedCollectorName= jwtToken.getCollectornameFromToken(stringToken);
//
//        if(authenticatedCollectorName.equals(collectPaymentsName)){
//            collectPaymentsForUpdating.setName(collectPayments.getName());
//            collectPaymentsForUpdating.setDescription(collectPayments.getDescription());
//            collectPaymentsForUpdating.setPrice(collectPayments.getPrice());
//
//            collectPaymentsRepository.save(collectPaymentsForUpdating);
//            return  new ResponseEntity("CollectPayments has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("You are not authorize to update this CollectPayments.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
