CREATE TABLE IF NOT EXISTS tester
(
    id   UUID PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    birth_date DATE NOT NULL,
    sex VARCHAR(1) NOT NULL,
    tests_done INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS measure
(
    id   UUID PRIMARY KEY,
    tester_id UUID NOT NULL
    creation_date TIMESTAMP NOT NULL,
    CONSTRAINT measure_tester_fk references tester (id),
    height DECIMAL(8, 2) NOT NULL,
    weight DECIMAL(8, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS brand
(
    id   UUID PRIMARY KEY,
    name TEXT NOT NULL,
    logo TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS product
(
    id   UUID PRIMARY KEY,
    sku TEXT NOT NULL,
    sizes TEXT NOT NULL,
    pictures TEXT NOT NULL,
    brand_id UUID NOT NULL
    CONSTRAINT product_brand_fk references brand (id),
    color TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS test
(
    id   UUID PRIMARY KEY,
    tester_id UUID NOT NULL
    CONSTRAINT test_tester_fk references tester (id),
    product_id UUID NOT NULL
    CONSTRAINT test_product_fk references product (id),
    size TEXT NOT NULL
);
