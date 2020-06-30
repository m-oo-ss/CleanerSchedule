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
public class PlanRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Plan> findAll() {

		// planテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbcTemplate.queryForList("select "
				+ "p.PLAN_ID ,p.PLAN_DATE , p.DATE_ID  ,b.BILL_NAME , s.STAFF_NAME , p.staff_id, p.bill_id, p.staff_number "
				+ "from plan p "
				+ "inner join staff s on p.staff_id = s. staff_id "
				+ "inner join bill b on b.bill_id = p.bill_id");

		// 結果返却用の変数
		List<Plan> planList = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			//Billインスタンスの生成
			Plan plan = new Plan();

			// Billインスタンスに取得したデータをセットする
			plan.setPlanId((Integer) map.get("plan_id")); //ビルID
			plan.setPlanDate((Date) map.get("plan_date")); //ビルID
			plan.setBillName((String) map.get("bill_name")); //ビルID
			plan.setStaffName((String) map.get("staff_name")); //ビル名
			plan.setDateId((Integer) map.get("date_id")); //ビル名
			plan.setStaffId((Integer) map.get("staff_id")); //ビル名
			plan.setBillId((Integer) map.get("bill_id")); //ビル名

			plan.setStaffNumber((Integer) map.get("staff_number")); //ビル名

			//結果返却用のListに追加
			planList.add(plan);
		}

		return planList;
	}

}