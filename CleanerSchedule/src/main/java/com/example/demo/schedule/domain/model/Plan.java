package com.example.demo.schedule.domain.model;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class Plan {

	private int planId; //プランID
	private Date planDate; //勤務日
	private int billId; //ビルID
	private int staffId; //スタッフID
	private String staffName;//スタッフ名
	private String billName;//ビル名
	private Time billStartTime;//勤務開始時間
	private Time billStopTime;//勤務終了時間
	private int restCheck;//休暇申請判定用
	private int staffNumber;
	private int dateId;
	private String billMap;
}