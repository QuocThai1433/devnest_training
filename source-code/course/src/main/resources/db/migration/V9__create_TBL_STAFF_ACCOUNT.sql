CREATE TABLE TBL_STAFF_ACCOUNT (
    id BIGINT PRIMARY KEY,
    staff_id BIGINT NOT NULL,
    login_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL,
    description TEXT,
    created_by VARCHAR(255) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_by VARCHAR(255),
    updated_date TIMESTAMP,
    CONSTRAINT fk_staff FOREIGN KEY (staff_id) REFERENCES tbl_staff(id) ON DELETE CASCADE
);