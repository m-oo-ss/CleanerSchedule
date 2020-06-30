package com.example.demo.schedule.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.schedule.domain.model.Staff;
import com.example.demo.schedule.domain.repository.StaffRepository;

@Service

public class StaffService {

	//スタッフ情報更新
	@Autowired
	private StaffRepository staffRepository;

	// 1件取得
	public Staff findOne(int staffId) {
		return staffRepository.findOne(staffId);
	}

	//1件更新
	public boolean updateOne(Staff staff) {
		// 判定用変数
		boolean result = false;
		// １件更新
		int rowNumber = staffRepository.updateOne(staff);
		if (rowNumber > 0) {
			// update成功
			result = true;
		}
		return result;

	}

	//新規登録
	/**
	 * insert用メソッド.
	 */
	public boolean insertOne(Staff staff) {
		// insert実行
		int rowNumber = staffRepository.insertOne(staff);
		// 判定用変数
		boolean result = false;
		if (rowNumber > 0) {
			// insert成功
			result = true;
		}
		return result;

	}

	// 複数件取得

	public List<Staff> findSearch(String StaffName) {

		return staffRepository.findSearch(StaffName);

	}

	//全件取得
	public List<Staff> findAll() {

		return staffRepository.findAll();
	}

}
