package com.example.hellospring.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Board {
    @Id
    @GeneratedValue
    @Column(name="board_id")
    private long id;

    private String title;
    private String contents;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus;

    @OneToMany(mappedBy = "board")
    @JoinColumn(name="comment_id")
    private List<Comment> comment;

    @Builder
    public Board(String title, String contents, Date regDate, BoardStatus status) {
        this.title = title;
        this.contents = contents;
        this.regDate = regDate;
        this.boardStatus = status;
    }

}
