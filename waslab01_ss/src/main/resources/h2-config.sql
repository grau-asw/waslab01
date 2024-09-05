CREATE TABLE TWEETS (
    TWID INT AUTO_INCREMENT PRIMARY KEY,
    TWAUTHOR VARCHAR(80),
    TWTEXT VARCHAR(800) NOT NULL,
    TWTIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);

INSERT INTO TWEETS(TWAUTHOR, TWTEXT, TWTIME) VALUES
('Sherlock', 'A cynic is a man who, when he smells flowers, looks around for a coffin.', TIMESTAMP '2024-09-01 14:56:11.0'),
('Mycroft', 'No married man is genuinely happy if he has to drink worse whisky than he used to drink when he was single.', TIMESTAMP '2024-09-02 17:23:45.0'),
('Sherlock', 'Before a man speaks it is always safe to assume that he is a fool. After he speaks, it is seldom necessary to assume it.', TIMESTAMP '2024-09-02 19:07:11.0'),
('Mycroft', 'Adultery is the application of democracy to love.', TIMESTAMP '2024-09-03 10:46:31.0'),
('Mycroft', 'A judge is a law student who marks his own examination papers.', TIMESTAMP '2024-09-04 10:06:11.0'),
('Sherlock', 'For every complex problem there is an answer that is clear, simple, and wrong.', TIMESTAMP '2024-09-04 11:16:01.0');
