package com.umich.ijulia.service.impl;

import com.umich.ijulia.dataobject.QuestionDetail;
import com.umich.ijulia.repository.QuestionDetailRepository;
import com.umich.ijulia.service.QuestionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionDetailServiceImpl implements QuestionDetailService {
    @Autowired
    private QuestionDetailRepository questionDetailRepository;
    @Override
    public int addQuestion(QuestionDetail question) {
        questionDetailRepository.save(question);
        return question.getId();
    }

    @Override
    public int upDateQuestion(QuestionDetail question) {
        return 0;
    }

    @Override
    public List<QuestionDetail> getLatestQuestions(int userId, int offset, int limit) {
        return null;
    }

    @Override
    public int updateCommentCount(int id, int count) {
        return 0;
    }
}
