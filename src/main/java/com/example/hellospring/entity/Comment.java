package com.example.hellospring.entity;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    @Column(name="column_id")
    private long id;

    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;
}
