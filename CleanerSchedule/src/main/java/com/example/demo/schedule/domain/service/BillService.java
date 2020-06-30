package com.example.demo.schedule.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.schedule.domain.model.Bill;
import com.example.demo.schedule.domain.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	// 全件取得
	public List<Bill> findAll() {
		return billRepository.findAll();
	}

	// 1件取得
	public Bill findOne(int billId) {

		return billRepository.findOne(billId);
	}

	//1件更新
	public boolean updateOne(Bill bill) {

		// 判定用変数
		boolean result = false;

		// １件更新
		int rowNumber = billRepository.updateOne(bill);
		if (rowNumber > 0) {
			// update成功
			result = true;
		}
		return result;
	}

	//ビル削除

	public boolean deleteOne(int billId) {
		int rowNumber = billRepository.deleteOne(billId);
		boolean result = false;
		if (rowNumber > 0) {
			// delete成功
			result = true;
		}
		return result;

	}

	//bill新規登録
	//insert用メソッド.

	public boolean insert(Bill bill) {

		// insert実行
		int rowNumber = billRepository.insertOne(bill);

		// 判定用変数
		boolean result = false;

		if (rowNumber > 0) {
			// insert成功
			result = true;
		}

		return result;
	}

}
