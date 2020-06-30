package com.example.demo.schedule.domain.model;

import java.sql.Date;

import lombok.Data;

@Data
public class StaffForm {

	private int staffId; //従業員ID
	private String staffName; //従業員名
	private String staffAddress; //従業員住所
	private String staffMail; //従業員メールアドレス
	private String staffTel; //従業員電話番号
	private String staffPass; //従業員パスワード
	private Date staffStart; //従業員勤務開始日
	private Date staffStop; //従業員勤務終了日
	private int shiftId; //従業員シフトID

}
