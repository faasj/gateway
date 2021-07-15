--liquibase formatted sql

--changeset semibratov_ilya:1
CREATE TABLE IF NOT EXISTS functions
(
    function_id           UUID,
    function_name         VARCHAR(255) NOT NULL,
    code                  TEXT         NOT NULL,
    description           VARCHAR(255),
    image                 VARCHAR(255),
    create_date           TIMESTAMP    NOT NULL,
    update_date           TIMESTAMP,
    project_id            UUID         NOT NULL,
    tags                  JSONB,
    environment_variables JSONB,
    limits                JSONB,
    requests              JSONB,
    annotations           JSONB,

    PRIMARY KEY (function_id),
    UNIQUE (function_name)
);

CREATE TABLE IF NOT EXISTS projects
(
    project_id   UUID,
    project_name VARCHAR(255) NOT NULL,
    create_date  TIMESTAMP    NOT NULL,
    update_date  TIMESTAMP,
    owner_id     UUID         NOT NULL,
    tags         JSONB,

    PRIMARY KEY (project_id),
    UNIQUE (project_name)
);
