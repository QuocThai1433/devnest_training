package com.devnest.common.import_service;

public interface CsvMapper<T> {
    T map(String[] csvRow);
}
