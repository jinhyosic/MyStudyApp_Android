package com.jhs.mystudyapp;

public class RecyclerFrItemData {
    String name,age,sex,hp,addr;

    public RecyclerFrItemData(String name, String age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hp = hp;
        this.addr = addr;
    }
    public String getName(){
        return name;
    }
    public  void setName(String name){
        this.name = name;
    }
    public String getAge(){
        return age;
    }
    public  void setAge(String age){
        this.age = age;
    }
    public String getSex(){
        return sex;
    }
    public  void setSex(String sex){
        this.sex = sex;
    }
    public String getHp(){
        return hp;
    }
    public  void setHp(String hp){
        this.hp = hp;
    }
    public String getAddr(){
        return addr;
    }
    public  void setAddr(String addr){
        this.addr = addr;
    }
}
