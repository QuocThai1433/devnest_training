CREATE TABLE TBL_WEEKDAY (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    hours VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created_by VARCHAR(255) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    updated_by VARCHAR(255),
    updated_date TIMESTAMP
);
