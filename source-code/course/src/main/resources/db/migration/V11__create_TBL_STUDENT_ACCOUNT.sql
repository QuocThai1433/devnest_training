CREATE TABLE tbl_student_account (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    login_name VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    description TEXT,
    created_by VARCHAR(50) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50),
    updated_date TIMESTAMP,
    CONSTRAINT fk_student
        FOREIGN KEY (student_id)
        REFERENCES tbl_student(id)
);