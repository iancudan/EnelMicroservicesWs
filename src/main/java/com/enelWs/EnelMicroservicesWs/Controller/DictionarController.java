package com.enelWs.EnelMicroservicesWs.Controller;

import com.enelWs.EnelMicroservicesWs.Entity.Dictionar;
import com.enelWs.EnelMicroservicesWs.Service.DictionarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionarController {

    @Autowired
    DictionarService dictionarService;


    @GetMapping("/getAllDictionar")
    public List<Dictionar> getAllDictionar(){
        return dictionarService.findAll();
    }

    @PostMapping("/addDictionar")
    public List<Dictionar> addDictionar(Dictionar dictionar){
        return dictionarService.addDictionar(dictionar);
    }

    @PostMapping("/updateDictionar")
    public List<Dictionar>  updateDictionar(Dictionar dictionar){
        return dictionarService.addDictionar(dictionar);
    }

    @PostMapping("/deleteDictionar")
    public List<Dictionar> deleteDictionar(Dictionar dictionar){
        return dictionarService.deleteDictionar(dictionar);
    }

}
