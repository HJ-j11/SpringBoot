package com.example.hellospring.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private long id;
    private String name;

    private String phone;

    @OneToMany
    @JoinColumn(name="board_id")
    private List<Board> boards;

    @OneToMany
    @JoinColumn(name="comment_id")
    private List<Comment> comments;


}
