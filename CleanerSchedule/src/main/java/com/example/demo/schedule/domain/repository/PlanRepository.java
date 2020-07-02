package com.example.demo.schedule.domain.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.schedule.domain.model.Plan;
import com.example.demo.schedule.domain.model.SelectForm;

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

	//idをもとに1件検索
	public Plan findOne(int planId) {

		// Staffテーブルのデータを全件取得
		Map<String, Object> map = jdbcTemplate.queryForMap("select "
                + "p.PLAN_ID , p.PLAN_DATE , b.BILL_NAME , s.STAFF_NAME , p.staff_id , p.bill_id , b.bill_starttime , b.bill_stoptime , p.rest_check "
                + "from plan p "
                + "inner join staff s on p.staff_id = s. staff_id "
                + "inner join bill b on b.bill_id = p.bill_id"
                + " WHERE plan_id = ?", planId);
		//Staffインスタンスの生成
		Plan plan = new Plan();

		// Staffインスタンスに取得したデータをセットする
		plan.setPlanId((Integer) map.get("plan_id")); //プランID
		plan.setPlanDate((Date) map.get("plan_date")); //勤務日
		plan.setBillId((Integer) map.get("bill_id")); //ビルID
		plan.setStaffId((Integer) map.get("staff_id"));//スタッフID
		plan.setStaffName((String) map.get("staff_name"));//スタッフ名
		plan.setBillName((String) map.get("bill_name"));//ビル名
		plan.setBillStartTime((java.sql.Time) map.get("bill_starttime"));//勤務開始時間
		plan.setBillStopTime((java.sql.Time) map.get("bill_stoptime"));//勤務終了時間
		plan.setRestCheck((int) map.get("rest_check"));//休暇申請判定



		return plan;
	}

//rest_checkの値をfalseに変換
//public int updateOne(Plan plan) throws DataAccessException {
//
//	int rowNumber = jdbcTemplate.update(
//				"UPDATE plan"
//						+ " SET"
//						+ " rest_check = false"
//						+ " WHERE plan_id = ?",
//				plan.getRestCheck()
//
//		);
//
//		return rowNumber;
//	}



	//休み希望のひとを検索
	public List<Plan> getRestList() {
		//
		List<Map<String, Object>> getList = jdbcTemplate.queryForList(
				"SELECT p.PLAN_ID, p.PLAN_DATE, p.STAFF_ID,p.BILL_ID,p.REST_CHECK,"
				+ " b.BILL_NAME,"
				+ " s.STAFF_NAME"
				+" FROM PLAN p "
				+"INNER JOIN STAFF s on p.STAFF_ID = s.STAFF_ID "
				+"INNER JOIN BILL b on b.BILL_ID = p.BILL_ID"
				+ " WHERE REST_CHECK = FALSE");

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
			plan.setStaffId((Integer)map.get("staff_id"));//スタッフID
			plan.setRestCheck((Boolean)map.get("rest_check"));//休み希望(falseに書き換わったものが休み希望)
			plan.setBillName((String)map.get("bill_name"));//ビル名
			plan.setStaffName((String)map.get("staff_name"));//スタッフ名

			//結果返却用のListに追加
			planList.add(plan);

		}

		return planList;
	}

	//休み希望のスタッフIDをnullに書き換える

	public int deleatePlan() throws DataAccessException {
		//
		int rowNumber = jdbcTemplate.update(
				"UPDATE PLAN SET STAFF_ID=1"
						+ " WHERE REST_CHECK=false");

		public int deleatePlan(Plan plan)throws DataAccessException {
	 		//
	 		int rowNumber = jdbcTemplate.update(
	 				"UPDATE PLAN SET STAFF_ID=NULL "
	 				+ "WHERE REST_CHECK=false)",


	//planテーブルの書き換え
	public int updateOne(SelectForm selectform) throws DataAccessException {
		//１件更新
		int rowNumber = 0;
		//selectformに入っている要素を取り出して変数selectに格納：なくなるまで繰り返し
		for (String select : selectform.getSelectForm()) {
			//String型配列contentsに"1,2020-01-01,2,3"をカンマ区切りで格納
			String[] contents = select.split(",", 0);

			rowNumber = jdbcTemplate.update(
					"UPDATE plan"
							+ " SET"
							+ " staff_id = ?,"
							+ " rest_check = 3"
							+ " WHERE bill_id = ?"
							+ " and plan_date = ?"
							+ " and staff_number = ?",
					contents[3],//セレクトボックスで選んだ人
					contents[0],//ビルid
					contents[1],//日付
					contents[2]);//何人目のスタッフか:j
		}
			return rowNumber;
		}

}