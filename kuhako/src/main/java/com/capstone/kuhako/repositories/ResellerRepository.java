package com.capstone.kuhako.repositories;

import com.capstone.kuhako.models.Reseller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResellerRepository extends CrudRepository<Reseller,Object> {
}