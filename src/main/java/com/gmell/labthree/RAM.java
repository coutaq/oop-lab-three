package com.gmell.labthree;

public class RAM implements IStorable{
    @Override
    public void store(Warehouse warehouse) {
        warehouse.Add(this);
    }
}
