package com.example.hellospring.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private long id;
    private String name;

    private String phone;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name="board_id")
    private List<Board> boards;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name="comment_id")
    private List<Comment> comments;


}
