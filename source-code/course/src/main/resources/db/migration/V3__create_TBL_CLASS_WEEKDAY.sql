CREATE TABLE TBL_CLASS_WEEKDAY (
    ID BIGINT PRIMARY KEY,                  -- ID: kiểu Long, khóa chính
    CLASS_ID BIGINT NOT NULL,                -- CLASS_ID: kiểu Long, yêu cầu
    WEEKDAY_ID BIGINT NOT NULL,              -- WEEKDAY_ID: kiểu Long, yêu cầu
    CREATED_BY VARCHAR(255) NOT NULL,        -- CREATED_BY: kiểu String, yêu cầu
    CREATED_DATE TIMESTAMP NOT NULL,         -- CREATED_DATE: kiểu Datetime, yêu cầu
    UPDATED_BY VARCHAR(255),                 -- UPDATED_BY: kiểu String, không yêu cầu
    UPDATED_DATE TIMESTAMP                   -- UPDATED_DATE: kiểu Datetime, không yêu cầu
);

