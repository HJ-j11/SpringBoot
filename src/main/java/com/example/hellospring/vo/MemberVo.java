package com.example.hellospring.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class MemberVo {
    @Id
    @GeneratedValue
    Long mbrNo;
    String name;
    String id;

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


//    public MemberVo(String name, String id) {
//        this.name = name;
//        this.id = id;
//    }

}
