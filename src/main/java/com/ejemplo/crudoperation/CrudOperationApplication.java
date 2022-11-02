package com.ejemplo.crudoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class CrudOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudOperationApplication.class, args);
        System.out.println("Mi primer CRUD");
    }


}

