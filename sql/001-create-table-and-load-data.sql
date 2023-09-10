-- テーブルが既に存在する場合、それを削除
DROP TABLE IF EXISTS prefecturalGovernments;

-- prefecturalGovernmentsテーブルを作成
CREATE TABLE prefecturalGovernments (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  postCode VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

-- prefecturalGovernmentsテーブルにデータを挿入
-- 文字列は 'シングルクォーテーション' で囲む
INSERT INTO prefecturalGovernments (name, postCode) VALUES ('北海道庁', '060-8588');
INSERT INTO prefecturalGovernments (name, postCode) VALUES ('青森県庁', '030-8570');
INSERT INTO prefecturalGovernments (name, postCode) VALUES ('岩手県庁', '020-8570');
INSERT INTO prefecturalGovernments (name, postCode) VALUES ('宮城県庁', '980-8570');
INSERT INTO prefecturalGovernments (name, postCode) VALUES ('秋田県庁', '010-8570');
