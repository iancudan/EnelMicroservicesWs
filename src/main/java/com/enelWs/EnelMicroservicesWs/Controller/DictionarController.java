package com.enelWs.EnelMicroservicesWs.Controller;

import com.enelWs.EnelMicroservicesWs.Entity.Dictionar;
import com.enelWs.EnelMicroservicesWs.Service.CustomUserDetailsService;
import com.enelWs.EnelMicroservicesWs.Service.DictionarService;
import com.enelWs.EnelMicroservicesWs.UTIL.DictionarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DictionarController {

    @Autowired
    DictionarService dictionarService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/getAllDictionar")
    public List<Dictionar> getAllDictionar(){
        return dictionarService.findAll();
    }

    @PostMapping("/addDictionar")
    public List<Dictionar> addDictionar(Dictionar dictionar){
        List<Dictionar> dictionarList = new ArrayList<>();
        dictionar.setUsername(customUserDetailsService.userPricipalDetails().getUsername());

        if(customUserDetailsService.isAdmin()){
            dictionar.setValid( DictionarUtil.VALID_TRUE.name());
            dictionar.setStatus(DictionarUtil.STATUS_APROBAT.name());
        }else{
            dictionar.setValid( DictionarUtil.VALID_FALSE.name());
            dictionar.setStatus(DictionarUtil.STATUS_PROPUS.name());
        }

        dictionarList = dictionarService.addDictionar(dictionar);
        return dictionarList;
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
