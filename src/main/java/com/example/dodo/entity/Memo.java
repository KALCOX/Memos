package com.example.dodo.entity;


//import com.example.dodo.dto.MemoRequestDto;
import com.example.dodo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String contents;

    public Memo(MemoRequestDto requestDto){
        this.title = requestDto.getUsertitle();
        this.username = requestDto.getUsername();
        this.pw = requestDto.getUserpw();
        this.contents = requestDto.getUsercontents();

    }
    public void update(MemoRequestDto requestDto){
        this.title = requestDto.getUsertitle();
        this.username = requestDto.getUsername();
        this.pw = requestDto.getUserpw();
        this.contents = requestDto.getUsercontents();
    }



//    public Memo(String title, String username, String pw ,String contents ) {
//        this.title = title;
//        this.username = username;
//        this.pw = pw;
//        this.contents = contents;
//    }


//
//    public Memo(MemoRequestDto requestDto) {
//        this.title = requestDto.getUsertitle();
//        this.username = requestDto.getUsername();
//        this.pw = requestDto.getUserpw();
//        this.contents = requestDto.getContents();
//    }
//
//    public void update(MemoRequestDto memoRequestDto) {
//        this.title = memoRequestDto.getUsertitle();
//        this.username = memoRequestDto.getUsername();
//        this.pw = memoRequestDto.getUserpw();
//        this.contents = memoRequestDto.getContents();
//    }


}
