package com.capstone.kuhako.repositories;

import com.capstone.kuhako.models.Collector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectorRepository extends CrudRepository<Collector,Object> {
}
