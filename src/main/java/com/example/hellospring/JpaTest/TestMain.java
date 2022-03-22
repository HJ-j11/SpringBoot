package com.example.hellospring.JpaTest;

import com.example.hellospring.vo.Member;
import com.example.hellospring.vo.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //트렌젝션 시작
        tx.begin();

        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member member1 = new Member();
        member1.setId("member1");
        member1.setName("회원1");
        member1.getProducts().add(productA);
        em.persist(member1);

        tx.commit();

        emf.close();

    }
}
