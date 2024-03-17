CREATE TABLE product
(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    created_at      datetime NULL,
    LastUpdatedAt datetime NULL,
    isdeleted      BIT(1) NOT NULL,
    title           VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id     BIGINT NULL,
    'description'   VARCHAR(255) NULL,
    imgUrl       VARCHAR(255) NULL,
    num_of_sales  BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE category
(
    id              BIGINT NOT NULL AUTO_INCREMENT,
    created_at      datetime NULL,
    LastUpdatedAt datetime NULL,
    isdeleted      BIT(1) NOT NULL,
    name            VARCHAR(255) NULL,
    'description'   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);