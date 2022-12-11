package com.enelWs.EnelMicroservicesWs.Service;

import com.enelWs.EnelMicroservicesWs.Entity.Dictionar;
import com.enelWs.EnelMicroservicesWs.Repository.DictionarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionarService {

    @Autowired
    DictionarRepository dictionarRepository;

    public List<Dictionar> findAll(){
        return dictionarRepository.findAll();
    }

    public Dictionar findById(Long id){
        List<Dictionar> all = dictionarRepository.findAll();
        Dictionar dictionar = new Dictionar();

        for (Dictionar d : all) {
            if (d.getId() == id) {
                dictionar = d;
            }
        }

        return dictionar;
    }

    public List<Dictionar> addDictionar(Dictionar dictionar){
        dictionarRepository.saveAndFlush(dictionar);
        return dictionarRepository.findAll();
    }

    public List<Dictionar> deleteDictionar(Dictionar dictionar){
        dictionarRepository.delete(dictionar);
        return dictionarRepository.findAll();
    }
}
