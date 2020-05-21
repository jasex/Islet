package com.service;

import com.entities.Quote;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * 从main_quote中提取三句
 */
public interface QuotePasser {
    public ArrayList<Quote> passQuote() throws SQLException;
}
