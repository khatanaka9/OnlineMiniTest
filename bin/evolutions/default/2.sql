# Usersテーブルにカラムを追加

# --- !Ups
ALTER TABLE user_table ADD INDEX user_idx1(login_id, login_pw);
ALTER TABLE user_table ADD INDEX user_idx2(token);

# --- !Downs
ALTER TABLE user_table DROP INDEX user_idx1(login_id, login_pw);
ALTER TABLE user_table DROP INDEX user_idx2(token);
