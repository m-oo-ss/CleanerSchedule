package com.example.demo.schedule.domain.model;

import java.sql.Time;

import lombok.Data;

@Data
public class Bill {

	private int billId; //ビルID
	private String billName; //ビル名
	private String billAddress; //住所
	private String billTel; //住所
	private int billPeople; //派遣人数
	private Time billStartTime; //ビルID
	private Time billStopTime; //ビルID
	private int billSun; //ビルID
	private int billMon; //ビルID
	private int billTue; //ビルID
	private int billWed; //ビルID
	private int billThu; //ビルID
	private int billFri; //ビルID
	private int billSat; //ビルID

}
