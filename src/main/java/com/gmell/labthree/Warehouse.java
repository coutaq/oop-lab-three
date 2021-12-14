package com.gmell.labthree;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Scope("singleton")
@Component("warehouseBean")
public class Warehouse{
    private ArrayList<IStorable> storage;

    public Warehouse() {
        this.storage = new ArrayList<IStorable>();
    }
    public void Add(IStorable item){
        this.storage.add(item);
    }

    public IStorable[]  Withdraw(Class cl, String name, int amount) {
        if(!IStorable.class.isAssignableFrom(cl)){
            throw new ClassCastException("что это такое мы тут такое не храним");
        }
        IStorable[] ret = new IStorable[amount];
        int index = 0 ;
        for (IStorable item:
             this.storage) {
            if(item.getClass() == cl){
                ret[index] = item;
                index++;
            }
        }
        if(index < amount){
            throw new IllegalArgumentException("На складе наворовали. на вас не хватило");
        }
        this.storage.remove(ret);
        return ret;
    }

}
