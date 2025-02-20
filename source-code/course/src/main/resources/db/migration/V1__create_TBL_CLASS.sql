CREATE TABLE tbl_class (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    teacher_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    description TEXT,
    created_by VARCHAR(255) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_by VARCHAR(255),
    updated_date TIMESTAMP
);


