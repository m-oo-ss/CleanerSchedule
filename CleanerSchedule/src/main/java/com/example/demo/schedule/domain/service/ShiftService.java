package com.example.demo.schedule.domain.service;

//package com.example.demo.trySpring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShiftService {
//
//	@Autowired
//	private ShiftRepository shiftRepository;
//
//
//	// 1件取得
//	public Shift findOne(int shiftId) {
//
//		return shiftRepository.findOne(shiftId);
//	}
//
//	//1件更新
//	public boolean updateOne(Shift shift) {
//
//		// 判定用変数
//		boolean result = false;
//
//		// １件更新
//		int rowNumber = shiftRepository.updateOne(shift);
//		if (rowNumber > 0) {
//			// update成功
//			result = true;
//		}
//		return result;
//	}
//
//}
