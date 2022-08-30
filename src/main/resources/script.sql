CREATE DATABASE game_db;

CREATE TABLE users(
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(128) NOT NULL,
                      email VARCHAR (128) NOT NULL UNIQUE ,
                      password VARCHAR (32) NOT NULL,
                      win_game INT,
                      lose_game INT
);