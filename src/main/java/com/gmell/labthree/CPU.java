package com.gmell.labthree;

public class CPU implements IStorable{
    @Override
    public void store(Warehouse warehouse) {
        warehouse.Add(this);
    }
}
