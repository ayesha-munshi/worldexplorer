/**
 * CREATE Script for init of DB
 */

--Create city table
CREATE TABLE city (
    id INTEGER PRIMARY KEY,
    city VARCHAR(64),
    country VARCHAR(64),
    continent VARCHAR(64)
);