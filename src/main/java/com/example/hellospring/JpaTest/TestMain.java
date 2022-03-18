package com.example.hellospring.JpaTest;

import com.example.hellospring.vo.MemberVo;
import com.example.hellospring.vo.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;

public class TestMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // transaction 시작
        tx.begin();
        
        emf.close();

    }
}
