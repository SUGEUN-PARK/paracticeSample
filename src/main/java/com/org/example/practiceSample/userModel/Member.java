package com.org.example.practiceSample.userModel;

/*@Getter @Setter*/
public class Member {
    private Long num;
    private  String name;
    private int age;
    public String id;
    public String password;

    public Member(){

    }
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }


}
