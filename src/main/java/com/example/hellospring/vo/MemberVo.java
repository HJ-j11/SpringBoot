package com.example.hellospring.vo;


import javax.persistence.*;


@Entity
public class MemberVo {
    @Id
    // 키 생성 테이블에 위임.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbrNo;

    // not null 조건 추가
    @Column(nullable = false)
    private String name;
    private String id;
    
    
    // 매핑 관계 설정
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    // 타임스탬프
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date;

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

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
    
    public MemberVo() {

    }

    public MemberVo(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
