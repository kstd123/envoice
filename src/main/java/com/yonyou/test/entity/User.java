package com.yonyou.test.entity;

import org.springframework.stereotype.Component;

/**
 * Created by xinggq on 17-3-24.
 */

@Component
public class User {

    private int id;
    private String name;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return "user[id:"+id+",name:"+name+",number:"+number+"]";
    }
}
