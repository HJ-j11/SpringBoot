package com.example.hellospring.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue
    @Column(name="board_id")
    private long id;

    private String title;
    private String contents;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus;

    @OneToMany
    @JoinColumn(name="comment_id")
    private List<Comment> comments;
}
