package com.example.hellospring.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
public class MemberVo {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    // 키 생성 테이블에 위임.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mbrNo;

    // not null 조건 추가
    @Column(nullable = false)
    String name;
    String id;

    // 타임스탬프
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


//    public MemberVo(String name, String id) {
//        this.name = name;
//        this.id = id;
//    }

}
