import com.example.hellospring.vo.MemberVo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // transaction 시작
        tx.begin();
        
        // try, catch, finally -> 에러 처리 필수(데이터베이스이기 때문).
       try {
           // 선언 및 setId, setName
           MemberVo member1 = new MemberVo("member1", "회원1");
           MemberVo member2 = new MemberVo("member2", "회원2");

           //커밋
           tx.commit();

       } catch (Exception e) {
           tx.rollback();
       } finally {
           em.close();
       }

        System.out.println("hello");
        emf.close();

    }
}
