package com.example.hellospring.JpaTest;


import com.example.hellospring.vo.MemberVo;
import com.example.hellospring.vo.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class updateRelation {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        MemberVo member1 = new MemberVo("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        MemberVo member2 = new MemberVo("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);

        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        MemberVo member = em.find(MemberVo.class, "member1");
        member.setTeam(team2);
    }
}
