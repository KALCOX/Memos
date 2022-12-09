package com.example.dodo.controller;


import com.example.dodo.dto.MemoRequestDto;
import com.example.dodo.entity.Memo;
import com.example.dodo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){

        return memoService.create(requestDto);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoService.getMemos();

    }
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        return  memoService.deleteMemo(id);
    }
    @GetMapping("/api/memos/{id}")
    public Memo findMemo(@PathVariable Long id){
        return memoService.findMemo(id);

    }


//    @GetMapping("/api/memos/{id}")
//    public Long List<Memo> findMemo(@PathVariable Long id){
//        return memoService.find(id);
//    }





}
