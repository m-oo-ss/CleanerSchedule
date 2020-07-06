package com.example.demo.schedule.domain.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.schedule.domain.model.Plan;

@Repository
public class AlertRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//休み希望のひとを検索
		public List<Plan> getAlerttList() {
			//
			List<Map<String, Object>> getList = jdbcTemplate.queryForList(
					"SELECT p.PLAN_ID, p.PLAN_DATE, p.STAFF_ID,p.BILL_ID,p.REST_CHECK,"
							+ " b.BILL_NAME,"
							+ " s.STAFF_NAME"
							+ " FROM PLAN p "
							+ "INNER JOIN STAFF s on p.STAFF_ID = s.STAFF_ID "
							+ "INNER JOIN BILL b on b.BILL_ID = p.BILL_ID"
							+ " WHERE REST_CHECK = 1");

			// 検索結果返却用の変数
			List<Plan> planList = new ArrayList<>();

			// 取得したデータを結果返却用のListに格納していく
			for (Map<String, Object> map : getList) {

				//プランクラスのインスタンスの生成
				Plan plan = new Plan();

				// Planインスタンスに取得したデータをセットする
				plan.setPlanId((Integer) map.get("plan_id"));//プランID
				plan.setPlanDate((Date) map.get("plan_date")); //スケジュール日付
				plan.setBillId((Integer) map.get("bill_id")); //ビルID
				plan.setStaffId((Integer) map.get("staff_id"));//スタッフID
				plan.setRestCheck((Integer) map.get("rest_check"));//休み希望(falseに書き換わったものが休み希望)
				plan.setBillName((String) map.get("bill_name"));//ビル名
				plan.setStaffName((String) map.get("staff_name"));//スタッフ名

				//結果返却用のListに追加
				planList.add(plan);

			}

			return planList;
		}

}
