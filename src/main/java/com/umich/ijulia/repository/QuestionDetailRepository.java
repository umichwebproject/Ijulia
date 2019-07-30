package com.umich.ijulia.repository;

import com.umich.ijulia.dataobject.QuestionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDetailRepository extends JpaRepository<QuestionDetail,Integer> {
    QuestionDetail findById(int id);
}
