package com.gmell.labthree;

public class GPU implements IStorable{
    @Override
    public void store(Warehouse warehouse) {
        warehouse.Add(this);
    }
}
