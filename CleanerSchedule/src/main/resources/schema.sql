/*シフトパターン詳細テーブル作成*/

CREATE TABLE IF NOT EXISTS shift(

shift_id INT AUTO_INCREMENT,

shift_day INT,

shift_mon INT ,

shift_tue INT,

shift_wed INT,

shift_thr INT,

shift_fri INT,

shift_sat INT,

shift_sun INT,

PRIMARY KEY(shift_id)

);



/*従業員テーブルの作成*/

CREATE TABLE IF NOT EXISTS staff(

staff_id INT AUTO_INCREMENT,

staff_name VARCHAR(50),

staff_address VARCHAR(200) ,

staff_mail VARCHAR(200),

staff_tel VARCHAR(50),

staff_pass VARCHAR(200),

staff_start DATE,

staff_stop DATE DEFAULT  '2200-12-31',

shift_id INT,

PRIMARY KEY(staff_id),

FOREIGN KEY(shift_id) REFERENCES shift(shift_id)

);



/*オーナーテーブル作成*/

CREATE TABLE IF NOT EXISTS owner(

owner_id INT AUTO_INCREMENT,

owner_name VARCHAR(50),

owner_tel VARCHAR(50),

PRIMARY KEY(owner_id)

);



/*掃除頻度テーブル作成*/

CREATE TABLE IF NOT EXISTS workshift(

workshift_id INT AUTO_INCREMENT,

work_shift_day INT,

work_capacity INT,

work_mon INT,

work_tue INT,

work_wed INT,

work_thr INT,

work_fri INT,

work_sat INT,

work_sun INT,

PRIMARY KEY(workshift_id)

);



/*ビルテーブル作成*/

CREATE TABLE IF NOT EXISTS bill(

bill_id INT AUTO_INCREMENT,

bill_name VARCHAR(50),

bill_address VARCHAR(200),

bill_tel VARCHAR(50),

bill_starttime TIME,

bill_stoptime TIME,

bill_people INT,

bill_sunday INT,

bill_monday INT,

bill_tuesday INT,

bill_wednesday INT,

bill_thursday INT,

bill_friday INT,

bill_saturday INT,

owner_id  INT,

workshift_id INT,

PRIMARY KEY (bill_id)  ,

FOREIGN KEY(owner_id) REFERENCES  owner(owner_id) ,

FOREIGN KEY(workshift_id)REFERENCES workshift(workshift_id)

);



/*スケジュールテーブル作成*/

CREATE TABLE IF NOT EXISTS plan(

plan_id int AUTO_INCREMENT,

plan_date date,

bill_id int,

staff_id int,

date_id int,
staff_number int,
/*op varchar(50),*/

PRIMARY KEY (plan_id),

FOREIGN KEY(bill_id) REFERENCES  bill(bill_id),

FOREIGN KEY(staff_id) REFERENCES  staff(staff_id)

);
