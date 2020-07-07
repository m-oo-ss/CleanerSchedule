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

VALUES ('管理太郎','福岡市中央区','aaa@aaa.co.jp','09090909090','pass1','2020-06-15',1);

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
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id,bill_map)

VALUES('博多駅前ビル', '福岡県福岡市博多区博多駅前１丁目２−１','06022223333','9:00:00','18:00:00',2,
0,1,1,1,1,1,0,1,'pb=!1m14!1m8!1m3!1d830.8807779632909!2d130.4185678!3d33.5917292!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x354191c64cbf5399%3A0xb3a3b3ae2f89d933!2z44K144O844OW44Kz44O844OXTk1G5Y2a5aSa6aeF5YmN44OT44Or!5e0!3m2!1sja!2sjp!4v1594089454478!5m2!1sja!2sjp');

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id,bill_map)

VALUES('博多駅新三井ビル', '福岡県福岡市博多区博多駅前１丁目１−１','0602223333','9:00:00','13:00:00',1,
1,1,1,0,1,1,1,1,'pb=!1m18!1m12!1m3!1d13293.384958163615!2d130.38902143766413!3d33.59631975318229!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x354191c70c07c039%3A0x6d91aa48c22c2fad!2z5Y2a5aSa6aeF5paw5LiJ5LqV44OT44Or!5e0!3m2!1sja!2sjp!4v1594019110263!5m2!1sja!2sjp');

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id,bill_map)

VALUES('須崎ビル','福岡県福岡市中央区天神５丁目３−１','06033334444','17:00:00','18:00:00',1,
1,1,0,1,1,0,1, 2,'pb=!1m18!1m12!1m3!1d3323.3462269197553!2d130.39558751520306!3d33.59632008073247!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3541918ce355b185%3A0x694f18e20754be61!2z44CSODEwLTAwMDEg56aP5bKh55yM56aP5bKh5biC5Lit5aSu5Yy65aSp56We77yV5LiB55uu77yT4oiS77yRIOmgiOW0juODk-ODqw!5e0!3m2!1sja!2sjp!4v1594018984247!5m2!1sja!2sjp');

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id,bill_map)

VALUES('天神ビル新館','福岡県福岡市中央区天神４丁目３−３０','06033334444','11:00:00','15:00:00',1,
1,1,1,1,1,1,1, 2,'pb=!1m18!1m12!1m3!1d3323.4545516523017!2d130.39678221545438!3d33.593508680733244!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3541919437e6f781%3A0xa0189d48fbcb6350!2z5aSp56We44OT44Or5paw6aSo!5e0!3m2!1sja!2sjp!4v1594018826851!5m2!1sja!2sjp');

INSERT INTO bill (bill_name, bill_address,bill_tel, bill_starttime, bill_stoptime, bill_people,
bill_sunday, bill_monday, bill_tuesday, bill_wednesday, bill_thursday, bill_friday, bill_saturday, owner_id,bill_map)

VALUES('JR九州システムソリューションズ','福岡県福岡市博多区吉塚本町１３−７９','06055556666','8:00:00','22:00:00',1,
1,1,1,0,1,1,1, 3,'pb=!1m18!1m12!1m3!1d794.3944486644208!2d130.42376606938808!3d33.60740662115111!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x48308504f0c726b0!2z77yq77yy5Lmd5bee44K344K544OG44Og44K944Oq44Ol44O844K344On44Oz44K677yI5qCq77yJ!5e0!3m2!1sja!2sjp!4v1594017999818!5m2!1sja!2sjp');

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

