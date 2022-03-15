package com.example.hellospring.vo;

public class MemberVo {
    Long mbrNo;
    String name;

    public Long getMbrNo() {
        return mbrNo;
    }

    public void setMbrNo(Long mbrNo) {
        this.mbrNo = mbrNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String id;
    String city;

    public MemberVo(String name, String id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

}
