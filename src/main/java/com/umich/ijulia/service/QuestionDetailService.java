package com.umich.ijulia.service;

import com.umich.ijulia.dataobject.QuestionDetail;

import java.util.List;

public interface QuestionDetailService {
    //增加问题
    int addQuestion(QuestionDetail question);
    //删除问题
    //修改问题
    int upDateQuestion(QuestionDetail question);
    //获取最近的问题
    List<QuestionDetail> getLatestQuestions(int userId, int offset, int limit);
    //更新评论
    int updateCommentCount(int id, int count);
}
