ALTER TABLE account DROP COLUMN parent;
ALTER TABLE account ADD COLUMN owner_id INT NOT NULL REFERENCES user (id);