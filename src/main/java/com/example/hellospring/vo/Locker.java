package com.example.hellospring.vo;


import javax.persistence.*;

@Entity
public class Locker {
    @Id @GeneratedValue
    @Column(name="LOCKED_ID")
    private long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

}
