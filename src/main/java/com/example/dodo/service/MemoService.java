package com.example.dodo.service;

import com.example.dodo.dto.MemoRequestDto;
import com.example.dodo.entity.Memo;
import com.example.dodo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo create(MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true)
    public List<Memo> getMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }


    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @Transactional(readOnly = true)
    public Memo findMemo(Long id){
        return memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("찾을 수 없는 데이터 입니다.")
        );
    }

//    public List<Memo> find(Long id) {
//        Memo find = memoRepository.findById(id).orElseThrow(
//                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//         find.find(re)
//    }
}
