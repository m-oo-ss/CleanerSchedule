package com.example.demo.schedule.domain.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Plan {

	private int planId; //ビルID
	private Date planDate; //ビル名
	private String billName; //ビルID
	private String staffName; //ビルID
	private int dateId; //ビルID
	private int staffId; //ビルID
	private int billId; //ビルID
	private boolean restCheck;//休み申請

	private int StaffNumber; //ビルID
}