package com.enelWs.EnelMicroservicesWs.UTIL;

public enum DictionarUtil {

    STATUS_APROBAT("aprobat"),
    STATUS_PROPUS("propus"),
    VALID_TRUE("true"),
    VALID_FALSE("false");


    private final String name;

    DictionarUtil (String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
