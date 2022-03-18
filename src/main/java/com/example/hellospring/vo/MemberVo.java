package com.example.hellospring.vo;


import javax.persistence.*;


@Entity
public class MemberVo {
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

    public MemberVo() {

    }

    public MemberVo(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
