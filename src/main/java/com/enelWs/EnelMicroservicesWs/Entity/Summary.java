package com.enelWs.EnelMicroservicesWs.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Summary {

    @Id
    private Long id;
    private String xmlFile;
    private String anreXml;

}
