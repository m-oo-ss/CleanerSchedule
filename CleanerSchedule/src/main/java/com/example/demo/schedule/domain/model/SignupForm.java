package com.example.demo.schedule.domain.model;

import java.sql.Time;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignupForm {

	//必須入力、長さ4から100桁まで、半角英数字のみ
	@NotBlank
	//        @Length(groups = ValidGroup2.class, message = "{length_check}")
	//        @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class, message = "{pattern_check}")
	private String billName; //ビル名

	//必須入力
	@NotBlank
	private String billAddress; // 住所

	//必須入力、メールアドレス形式
	@NotBlank
	private String billTel; //電話

	//必須入力
	@NotBlank
	private String ownerName; // オーナー名

	//必須入力
	@NotBlank
	private String ownerTel; // オーナー電話

	private int billPeople; //ビルID
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
