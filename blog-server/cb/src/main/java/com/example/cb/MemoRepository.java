package com.example.cb;

import org.springframework.data.repository.CrudRepository;


public interface MemoRepository extends CrudRepository<Memo, Long> {
}
