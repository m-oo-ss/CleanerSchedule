package com.example.demo.schedule.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.schedule.domain.model.Owner;
import com.example.demo.schedule.domain.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	//    // 全件取得
	//    public List<Bill> findAll() {
	//        return billRepository.findAll();
	//    }
	//
	// 1件取得
	public Owner findOne(int billId) {

		return ownerRepository.findOne(billId);
	}
	//
	//    //1件更新
	//    public boolean updateOne(Bill bill) {
	//
	//        // 判定用変数
	//        boolean result = false;
	//
	//        // １件更新
	//        int rowNumber = billRepository.updateOne(bill);
	//        if (rowNumber > 0) {
	//            // update成功
	//            result = true;
	//        }
	//        return result;
	//    }
	//
	//    //ビル削除
	//
	//    public boolean deleteOne(int billId) {
	//        int rowNumber = billRepository.deleteOne(billId);
	//        boolean result = false;
	//        if (rowNumber > 0) {
	//            // delete成功
	//            result = true;
	//        }
	//        return result;
	//
	//    }

	//オーナー新規登録

	public boolean insert(Owner owner) {

		// insert実行
		int rowNumber = ownerRepository.insertOne(owner);

		// 判定用変数
		boolean result = false;

		if (rowNumber > 0) {
			// insert成功
			result = true;
		}

		return result;
	}

}
