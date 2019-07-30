package com.umich.ijulia.service.impl;

import com.umich.ijulia.dataobject.QuestionDetail;
import com.umich.ijulia.service.QuestionDetailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionDetailServiceImplTest {
    @Autowired
    private QuestionDetailService questionDetailService;
    @Test
    public void addQuestion() {
        QuestionDetail questionDetail = new QuestionDetail();
        questionDetail.setUserId(1);
        questionDetail.setTitle("字节跳动biss");
        questionDetail.setContent("就直说了，字节biss嗷");
        int result = questionDetailService.addQuestion(questionDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void upDateQuestion() {
    }

    @Test
    public void getLatestQuestions() {
    }

    @Test
    public void updateCommentCount() {
    }
}