/*
package com.devnest.common.import_service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommonImportService<T> {

    private final JpaRepository<T, Long> repository;

    public CommonImportService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public void importFromCsv(InputStream inputStream, CsvMapper<T> mapper) {
        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            String[] line;
            // skip title
            reader.readNext(); // read title line

            while ((line = reader.readNext()) != null) {
                if (isLineEmpty(line)) continue;

                T entity = mapper.map(line);
                repository.save(entity);
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // check if the line is empty
    private boolean isLineEmpty(String[] line) {
        for (String value : line) {
            if (value != null && !value.trim().isEmpty()) {
                return false; // if the value is not empty, line is not empty
            }
        }
        return true; // all values are empty
    }

    public void importFromExcel(InputStream inputStream, ExcelMapper<T> mapper) {
        try (Workbook workbook = new XSSFWorkbook(inputStream)){
            Sheet sheet = workbook.getSheetAt(0);
            for (int rowIndex = 1; rowIndex < sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null || isRowEmpty(row)) continue;

                T entity = mapper.map(row); // use mapper to map Excel rows to entities
                repository.save(entity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isRowEmpty(Row row) {
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false; // if there are cell not empty, rows not empty
            }
        }
        return true; // if all cells are empty, rows are empty
    }

}
*/