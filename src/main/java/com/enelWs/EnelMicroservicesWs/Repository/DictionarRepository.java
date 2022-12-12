package com.enelWs.EnelMicroservicesWs.Repository;

import com.enelWs.EnelMicroservicesWs.Entity.Dictionar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionarRepository extends JpaRepository<Dictionar,Long> {


    List<Dictionar> findAllByStatusAndValid(String status,String valid);
}
