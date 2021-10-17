package com.gmell.labthree;

import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
@Scope("singleton")
public class Warehouse{
    private ArrayList<IStorable> storage;

    public Warehouse() {
        this.storage = new ArrayList<IStorable>();
    }
    public void Add(IStorable item){
        this.storage.add(item);
    }
}
