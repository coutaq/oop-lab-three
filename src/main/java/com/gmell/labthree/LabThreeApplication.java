package com.gmell.labthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LabThreeApplication {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Warehouse wh = context.getBean("warehouseBean", Warehouse.class);
        wh.Add(new CPU());
        try{
        wh.Withdraw(CPU.class,"Миша", 1);
        wh.Withdraw(GPU.class,"Миша", 1);
        wh.Withdraw(Warehouse.class,"Миша", 1);
        }catch (Exception e){}
    }


}
