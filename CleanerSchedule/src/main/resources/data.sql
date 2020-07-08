/*シフトパターン詳細テーブル挿入Sample*/



INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(0,0,0,0,0,0,0,0);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(2,0,1,0,1,0,0,0);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(2,0,0,0,0,0,1,1);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(2,0,1,1,0,0,0,0);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(3,1,0,1,0,0,1,0);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(3,1,0,0,1,0,0,1);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(4,1,1,0,0,0,1,1);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(4,0,1,1,1,1,0,0);

INSERT INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(5,0,1,1,1,1,0,1);

INSERT  INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(5,0,0,1,1,1,1,1);

INSERT  INTO shift(shift_day,shift_mon,shift_tue,shift_wed,shift_thr,shift_fri,shift_sat,shift_sun)

VALUES(6,1,0,1,1,1,1,1);











/*従業員情報テーブル挿入sample*/



INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES ('管理太郎','福岡市中央区','aaaa@ggg.kkk','09090909090','pass1','2020-06-15',1);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES ('本宮花子','福岡市博多区吉塚','aaa@aaa.co.jp','09000001111','pass2','2020-06-15',2);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES ('二宮花子','福岡市早良区','bbb@aaa.co.jp','09000011111','pass3','2020-06-15',3);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('三宮花子','福岡市南区','ccc@aaa.co.jp','09000021111','pass4','2020-06-15',4);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('四宮花子','福岡市博多区駅東','ddd@aaa.co.jp','09000031111','pass5','2020-06-15',5);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('鈴木花子','福岡市西区野方','eee@aaa.co.jp','09000041111','pass6','2020-06-15',6);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('田中花子','福岡市東区照葉','fff@aaa.co.jp','09000051111','pass7','2020-06-15',7);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('佐藤花子','福岡市博多区博多南','aba@aaa.co.jp','09000061111','pass8','2020-06-15',8);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('高橋花子','福岡市南区井尻','aac@aaa.co.jp','09000071111','pass9','2020-06-15',9);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('伊藤花子','福岡市博多区吉塚','bcb@aaa.co.jp','09099998888','pass10','2020-06-16',10);

INSERT INTO staff(staff_name, staff_address, staff_mail, staff_tel, staff_pass, staff_start, shift_id)

VALUES('中村花子','糟屋郡新宮町','ccn@aaa.co.jp','08091085939','pass11','2020-06-15',11);



/*オーナーテーブル挿入Sample*/



INSERT INTO owner(owner_name,owner_tel)

VALUES('山田太郎','06022223333');

INSERT INTO owner(owner_name,owner_tel)

VALUES('山本太郎','06033334444');

INSERT INTO owner(owner_name,owner_tel)

VALUES('山下太郎','06055556666');











/*掃除頻度テーブル挿入Sample*/



INSERT INTO workshift(work_capacity,work_shift_day,work_mon,work_tue,work_wed,work_thr,work_fri,work_sat,work_sun)

VALUES (1,3,1,0,1,0,1,0,0);

INSERT INTO workshift(work_capacity,work_shift_day,work_mon,work_tue,work_wed,work_thr,work_fri,work_sat,work_sun)

VALUES (1,0,1,0,1,0,0,0,0);

INSERT INTO workshift(work_capacity,work_shift_day,work_mon,work_tue,work_wed,work_thr,work_fri,work_sat,work_sun)

VALUES (1,1,0,1,0,1,0,0,0);

INSERT INTO workshift(work_capacity,work_shift_day,work_mon,work_tue,work_wed,work_thr,work_fri,work_sat,work_sun)

VALUES (1,1,0,0,1,0,1,0,0);

INSERT INTO workshift(work_capacity,work_shift_day,work_mon,work_tue,work_wed,work_thr,work_fri,work_sat,work_sun)

VALUES (2,0,1,0,0,1,0,1,0);

/*ビルテーブル挿入Sample（ビルオーナーと電話番号が一緒になっている）*/



INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id)

VALUES('ビルA', '福岡市南区日佐4-18-2','06022223333','9:00:00','18:00:00',2,
0,1,1,1,1,1,0,  1);

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id)

VALUES('ビルB', '福岡市南区日佐4-18-2','0602223333','9:00:00','13:00:00',1,
1,1,1,0,1,1,1,  1);

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id)

VALUES('ビルC','福岡市東区香椎','06033334444','17:00:00','18:00:00',1,
1,1,0,1,1,0,1, 2);

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id)

VALUES('ビルD','福岡市早良区','06033334444','11:00:00','15:00:00',1,
1,1,1,1,1,1,1, 2);

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id)

VALUES('ビルE','糟屋郡新宮町','06055556666','8:00:00','22:00:00',1,
1,1,1,0,1,1,1, 3);

/*スケジュールテーブルサンプルデータ*/

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-01', 1 ,2 , 1,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-01', 1 ,3 , 1,2);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-01', 2 ,4 ,1,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-01', 3 ,5, 1,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-01', 4 ,6,1,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-01', 5 ,7,1,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-02', 1 ,8,2,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-02', 1 ,9,2,2);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-02', 2 ,10,2,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-02', 3 ,11,2,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-02', 4 ,2,2,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-02', 5 ,3,2,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-03', 1 ,4,3,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-03', 1 ,5,3,2);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-03', 2 ,6,3,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-03', 3 ,7,3,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-03', 4 ,8,3,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-03', 5 ,9,3,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-04', 1 ,10,4,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-04', 1 ,11,4,2);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-04', 2 ,2,4,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-04', 3 ,3,4,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-04', 4 ,4,4,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-04', 5 ,5,4,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-05', 1 ,6,5,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-05', 1 ,7,5,2);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-05', 2 ,8,5,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-05', 3 ,9,5,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-05', 4 ,10,5,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-05', 5 ,11,5,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-06', 1 ,2,6,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-06', 1 ,3,6,2);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-06', 2 ,4,6,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-06', 3 ,5,6 ,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-06', 4 ,6,6,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-06', 5 ,7,6,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-07', 1 ,8,7,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-07', 1 ,9,7,2);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-07', 2 ,10,7,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-07', 3 ,11,7,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-07', 4 ,2,7,1);

INSERT INTO plan (plan_date,bill_id ,staff_id , date_id, staff_number)
VALUES('2020-07-07', 5 ,3,7,1);

