package com.example.cb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/memo")
public class MemoController {
    private MemoRepository memoRep;

    @Autowired
    public MemoController(MemoRepository memoRep){
        this.memoRep=memoRep;
    }

    @PostMapping
    public Memo put(@RequestParam String name,@RequestParam String age){
        return memoRep.save(new Memo(name,age));
    }

    @GetMapping
    public Iterable<Memo> list(){
        return memoRep.findAll();
    }

    @GetMapping(value="/{id}")
    public Optional<Memo> findOne(@PathVariable Long id){
        return memoRep.findById(id);
    }

    @PutMapping(value="/{id}")
    public Memo update(@PathVariable Long id,@RequestParam String name,@RequestParam String age){
        Optional<Memo> memo = memoRep.findById(id);
        memo.get().setName(name);
        memo.get().setAge(age);
        return memoRep.save(memo.get());
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        memoRep.deleteById(id);
    }
}
