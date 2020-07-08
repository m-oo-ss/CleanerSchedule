package com.example.demo.schedule.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.schedule.domain.model.Plan;
import com.example.demo.schedule.domain.model.SelectForm;
import com.example.demo.schedule.domain.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired
	private PlanRepository planRepository;

	// 全件取得
	public List<Plan> findAll() {
		return planRepository.findAll();
	}

	// 1件取得
	public Plan findOne(int planId) {


		return planRepository.findOne(planId);
	}

	//rest_checkの値をfalseに変換
		public boolean updateFalse(int planId) {

			// 判定用変数
			boolean result = false;

			// １件更新
			int rowNumber = planRepository.updateFalse(planId);
			if (rowNumber > 0) {
				// update成功
				result = true;
			}
			return result;
		}

	//休み申請者取得

	public List<Plan> getRestList() {

		return planRepository.getRestList();

	}

	//plan変更
	public boolean updateOne(SelectForm selectform) {

		// 判定用変数
		boolean result = false;

		// １件更新
		int rowNumber = planRepository.updateOne(selectform);
		if (rowNumber > 0) {
			// update成功
			result = true;
		}
		return result;
	}

	//スタッフIDをnullに書き換えている。
	public boolean deleatePlan() {
		// 判定用変数
		boolean result = false;
		// １件更新
		int rowNumber = planRepository.deleatePlan();
		if (rowNumber > 0) {
			// update成功
			result = true;
		}
		return result;
	}



	//rest_checkの値を1に変換（変更確認）
	public boolean restCheckConfirm(int staffId) {

		// 判定用変数
		boolean result = false;

		// １件更新
		int rowNumber = planRepository.restCheckConfirm(staffId);
		if (rowNumber > 0) {
			// update成功
			result = true;
		}
		return result;
	}
}