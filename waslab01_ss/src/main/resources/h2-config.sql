CREATE TABLE TWEETS (
    TWID INT AUTO_INCREMENT PRIMARY KEY,
    TWAUTHOR VARCHAR(80),
    TWTEXT VARCHAR(800) NOT NULL,
    TWTIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);

INSERT INTO TWEETS(TWAUTHOR, TWTEXT, TWTIME) VALUES
('Hamlet', 'What a piece of work is a man! How noble in reason, how infinite in faculties!', TIMESTAMP '2025-02-01 14:56:11.0'),
('Claudius', 'O, my offence is rank, it smells to heaven; it hath the primal eldest curse, a brother''s murder. Thus guilt shall plague my soul.', TIMESTAMP '2025-02-02 17:23:45.0'),
('Hamlet', 'To be, or not to be: that is the question: Whether ''tis nobler in the mind to suffer the slings and arrows of outrageous fortune.', TIMESTAMP '2025-02-02 19:07:11.0'),
('Claudius', 'The serpent that did sting thy father''s life now wears his crown.', TIMESTAMP '2025-02-03 10:46:31.0'),
('Claudius', 'Madness in great ones must not unwatched go; we must keep order in our state.', TIMESTAMP '2025-02-04 10:06:11.0'),
('Hamlet', 'There are more things in heaven and earth, Horatio, than are dreamt of in your philosophy.', TIMESTAMP '2025-02-04 11:16:01.0');
