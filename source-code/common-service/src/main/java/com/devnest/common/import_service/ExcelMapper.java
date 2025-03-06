package com.devnest.common.import_service;

import org.apache.poi.ss.usermodel.Row;

public interface ExcelMapper<T> {
    T map(Row row);
}
