CREATE TABLE events (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  event_id VARCHAR(255),
  event_type VARCHAR(255),
  event_data TEXT NOT NULL,
  entity_type VARCHAR(255) NOT NULL,
  entity_id VARCHAR(255) NOT NULL,
  triggering_event VARCHAR(255),
  metadata VARCHAR(255),
  published TINYINT DEFAULT 0
);



CREATE TABLE message (
  dbid BIGINT AUTO_INCREMENT PRIMARY KEY,
  id VARCHAR(255),
  destination VARCHAR(255) NOT NULL,
  headers TEXT NOT NULL,
  payload TEXT NOT NULL,
  creation_time BIGINT NOT NULL,
  published BOOLEAN NOT NULL,
  message_partition INT NULL
);


CREATE TABLE received_messages (
  consumer_id VARCHAR(255),
  message_id VARCHAR(255),
  creation_time BIGINT,
  published SMALLINT DEFAULT 0,
  PRIMARY KEY(consumer_id, message_id)
);

CREATE TABLE publishing_scheduled_messages (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  destination VARCHAR(255) NOT NULL,
  headers TEXT NOT NULL,
  payload TEXT NOT NULL,
  publish_time BIGINT NOT NULL
);

CREATE TABLE cdc_monitoring (
  reader_id VARCHAR(255) PRIMARY KEY,
  last_time BIGINT
);


CREATE TABLE offset_store (
  client_name VARCHAR(255) NOT NULL PRIMARY KEY,
  serialized_offset TEXT
);