package com.service;

import com.entities.Answer;

import java.sql.SQLException;

public interface AnswerPasser {
    public Answer passAnswer() throws SQLException;
}
