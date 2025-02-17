CREATE TABLE TBL_COURSE (
    id BIGINT PRIMARY KEY,
    lessons INT NOT NULL,
    term VARCHAR(255) NOT NULL,
    language_id BIGINT NOT NULL,
    level_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    description TEXT,
    created_by VARCHAR(255) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_by VARCHAR(255),
    updated_date TIMESTAMP
);



