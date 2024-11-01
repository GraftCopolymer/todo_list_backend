CREATE TABLE IF NOT EXISTS user(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS todo_item(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    finished INTEGER NOT NULL,
    title VARCHAR(255) NOT NULL,
    ddl DATE,
    FOREIGN KEY (user_id) REFERENCES user(id)
);