package com.dao;

import com.entities.Answer;

import java.sql.SQLException;


public interface AnswerDao {
    //答案只读
    public Answer getAnswerByid(int id) throws SQLException;
}
