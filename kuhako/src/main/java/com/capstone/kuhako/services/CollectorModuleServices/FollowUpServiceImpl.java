package com.capstone.kuhako.services.CollectorModuleServices;

import com.capstone.kuhako.models.CollectorModules.FollowUp;
import com.capstone.kuhako.repositories.CollectorModuleRepository.FollowUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FollowUpServiceImpl {
    @Autowired
    private FollowUpRepository followUpRepository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    JwtToken jwtToken;

    public void createFollowUp(FollowUp followUp){
//        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        FollowUp newFollowUp = new FollowUp();
        newFollowUp.setUser(followUp.getUser());
        newFollowUp.setPaymentStatus(followUp.getPaymentStatus());
        followUpRepository.save(newFollowUp);
    }
    public Iterable<FollowUp> getFollowUp(){
        return followUpRepository.findAll();
    }

    public ResponseEntity deleteFollowUp(Long id){
        followUpRepository.deleteById(id);
        return new ResponseEntity<>("FollowUp Deleted successfully", HttpStatus.OK);

//        FollowUp followUpForDeleting = followUpRepository.findById(id).get();
//        String followUpName = followUpForDeleting.getUser().getUsername();
//        String authenticatedUsername = jwtToken.getUsernameFromToken(stringToken);
//
//        if (authenticatedUsername.equals(followUpName)){
//            followUpRepository.deleteById(id);
//            return new ResponseEntity<>("FollowUp Delete Successfully", HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("You are not authorized to delete this FollowUp",HttpStatus.UNAUTHORIZED);
//        }
    }

    public ResponseEntity updateFollowUp(Long id, FollowUp followUp){
        FollowUp followUpForUpdate = followUpRepository.findById(id).get();

        followUpForUpdate.setUser(followUp.getUser());
        followUpForUpdate.setPaymentStatus(followUp.getPaymentStatus());

        followUpRepository.save(followUpForUpdate);

        return new ResponseEntity("FollowUp updated successfully", HttpStatus.OK);

//        FollowUp followUpForUpdating = followUpRepository.findById(id).get();
//        String followUpName = followUpForUpdating.getUser().getUsername();
//        String authenticatedUserName= jwtToken.getUsernameFromToken(stringToken);
//
//        if(authenticatedUserName.equals(followUpName)){
//            followUpForUpdating.setName(followUp.getName());
//            followUpForUpdating.setDescription(followUp.getDescription());
//            followUpForUpdating.setPrice(followUp.getPrice());
//
//            followUpRepository.save(followUpForUpdating);
//            return  new ResponseEntity("FollowUp has been Revised.", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("You are not authorize to update this FollowUp.",HttpStatus.UNAUTHORIZED);
//        }
    }
}
