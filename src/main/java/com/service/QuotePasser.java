package com.service;

import com.entities.Quote;

import java.sql.SQLException;

public interface QuotePasser {
    public Quote passQuote() throws SQLException;
}
