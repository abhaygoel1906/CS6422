CREATE TABLE Geo_Location(
    id BIGINT PRIMARY KEY,
    location_name VARCHAR(255)
);
 
CREATE TABLE User(
    uid BIGINT PRIMARY KEY,
    username VARCHAR(255),
    nickname VARCHAR(255),
    bio VARCHAR(255),
    join_date DATE,
    profile_pic_url VARCHAR(255),
    geo_location_id BIGINT,
    num_followers BIGINT,
    num_following BIGINT,
    is_verified BOOLEAN,
    is_private BOOLEAN,
    FOREIGN KEY (geo_location_id) REFERENCES Geo_Location(id)
);

CREATE TABLE Tweet(
    tid BIGINT PRIMARY KEY,
    author_id BIGINT,
    time_stamp TIMESTAMP,
    num_likes BIGINT,
    num_retweets BIGINT,
    text VARCHAR(280),
    FOREIGN KEY (author_id) REFERENCES User(uid)
);

CREATE TABLE Follows(
    follower_id BIGINT, 
    following_id BIGINT,
    PRIMARY KEY (follower_id, following_id),
    FOREIGN KEY (follower_id) REFERENCES User(uid),
    FOREIGN KEY (following_id) REFERENCES User(uid)
);

CREATE TABLE Retweets(
    retweeter_id BIGINT,
    retweeted_id BIGINT,
    PRIMARY KEY (retweeter_id, retweeted_id),
    FOREIGN KEY (retweeter_id) REFERENCES Tweet(tid),
    FOREIGN KEY (retweeted_id) REFERENCES Tweet(tid)
);

CREATE TABLE Mentions(
    tid BIGINT,
    uid BIGINT,
    PRIMARY KEY (tid, uid),
    FOREIGN KEY (tid) REFERENCES Tweet(tid),
    FOREIGN KEY (uid) REFERENCES User(uid)
);