package com.example.hellospring.vo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    private String id;

    // not null 조건 추가
    @Column(nullable = false)
    private String name;

    // 매핑 관계 설정
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    @OneToOne
    private Locker locker;

    @ManyToMany
    @JoinTable(name="MEMBER_PRODUCT", joinColumns = @JoinColumn(name="MEMBER_ID"),
    inverseJoinColumns = @JoinColumn(name="PRODUCT_ID"))
    private List<Product> products = new ArrayList<Product>();

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Member() {

    }

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
