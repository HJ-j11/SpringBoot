package com.example.hellospring.vo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @Column(name="TEAM_ID")
    private String id;
    private String name;

    @OneToMany
    private List<MemberVo> members = new ArrayList<MemberVo>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberVo> getMembers() {
        return members;
    }

    public void setMembers(List<MemberVo> members) {
        this.members = members;
    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team() {

    }
}
