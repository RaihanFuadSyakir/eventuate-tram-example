CREATE TABLE message (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    destination VARCHAR(255) NOT NULL,
    headers TEXT NOT NULL,
    payload TEXT NOT NULL,
    creation_time BIGINT NOT NULL,
    published BOOLEAN NOT NULL,
    message_partition INT NULL
);

CREATE TABLE received_messages (
    consumer_id VARCHAR(255) NOT NULL,
    message_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (consumer_id, message_id)
);

CREATE TABLE publishing_scheduled_messages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    destination VARCHAR(255) NOT NULL,
    headers TEXT NOT NULL,
    payload TEXT NOT NULL,
    publish_time BIGINT NOT NULL
);