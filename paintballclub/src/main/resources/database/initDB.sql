CREATE TABLE IF NOT EXISTS  users
(
    id BIGSERIAL PRIMARY KEY ,
    user_name VARCHAR NOT NULL ,
    password VARCHAR NOT NULL ,
    user_role VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS meetings
(
    id BIGSERIAL PRIMARY KEY ,
    meetingtime VARCHAR NOT NULL ,
    numofusers INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS usertomeeting
(
    id BIGSERIAL PRIMARY KEY ,
    userid INTEGER NOT NULL,
    meetingid BIGSERIAL NOT NULL
);