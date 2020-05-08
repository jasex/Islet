package com.service;

import com.entities.Quote;

import java.sql.SQLException;

public class OutPutQuote {
    public static Quote getQuote() throws SQLException {
        QuotePasserImpl quotePasser=QuotePasserImpl.getInstance();
        //随机pass一个quote
        return quotePasser.passQuote();
    }
}
