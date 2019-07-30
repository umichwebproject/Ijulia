package com.umich.ijulia.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class QuestionDetail {
    @Id
    int id;
    String title;
    String content;
    int userId;
    Date createdDate;
    int commentCount;
}
