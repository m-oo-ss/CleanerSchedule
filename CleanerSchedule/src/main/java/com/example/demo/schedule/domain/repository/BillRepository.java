package com.example.demo.schedule.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.schedule.domain.model.Bill;

@Repository
public class BillRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Bill> findAll() {

		// billテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbcTemplate.queryForList("SELECT * FROM bill");

		// 結果返却用の変数
		List<Bill> billList = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			//Billインスタンスの生成
			Bill bill = new Bill();

			// Billインスタンスに取得したデータをセットする
			bill.setBillId((Integer) map.get("bill_id")); //ビルID
			bill.setBillName((String) map.get("bill_name")); //ビル名
			bill.setBillAddress((String) map.get("bill_address")); //ビルID
			bill.setBillPeople((Integer) map.get("bill_people")); //派遣人数
			bill.setBillStartTime((java.sql.Time) map.get("bill_starttime")); //ビルID
<<<<<<< HEAD
			bill.setBillStopTime((java.sql.Time) map.get("bill_stoptime"));
=======
			bill.setBillStopTime((java.sql.Time) map.get("bill_stoptime")); //ビルID
>>>>>>> master
			bill.setBillSun((Integer) map.get("bill_sunday")); //日曜仕事
			bill.setBillMon((Integer) map.get("bill_monday")); //月曜仕事
			bill.setBillTue((Integer) map.get("bill_tuesday")); //火曜仕事
			bill.setBillWed((Integer) map.get("bill_wednesday")); //水曜仕事
			bill.setBillThu((Integer) map.get("bill_thursday")); //木曜仕事
			bill.setBillFri((Integer) map.get("bill_friday")); //金曜仕事
			bill.setBillSat((Integer) map.get("bill_saturday")); //土曜仕事


			//結果返却用のListに追加
			billList.add(bill);
		}

		return billList;
	}

	//idをもとに1件検索
	public Bill findOne(int billId) {

		// billテーブルのデータを全件取得
		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT"
				+ " *"
				+ " FROM bill  INNER JOIN" +
				" owner " +
				" ON" +
				" bill.owner_id = owner.owner_id" + " WHERE bill_id = ?", billId);

		//Billインスタンスの生成
		Bill bill = new Bill();
		//        Owner owner = new Owner();

		// Billインスタンスに取得したデータをセットする
		bill.setBillId((Integer) map.get("bill_id")); //ビルID
		bill.setBillName((String) map.get("bill_name")); //ビル名
		bill.setBillAddress((String) map.get("bill_address")); //住所
		bill.setBillPeople((Integer) map.get("bill_people")); //ビルID
		bill.setBillStartTime((java.sql.Time) map.get("bill_starttime")); //ビルID
		bill.setBillStopTime((java.sql.Time) map.get("bill_stoptime"));
		bill.setBillSun((Integer) map.get("bill_sunday")); //ビルID
		bill.setBillMon((Integer) map.get("bill_monday")); //ビルID
		bill.setBillTue((Integer) map.get("bill_tuesday")); //ビルID
		bill.setBillWed((Integer) map.get("bill_wednesday")); //ビルID
		bill.setBillThu((Integer) map.get("bill_thursday")); //ビルID
		bill.setBillFri((Integer) map.get("bill_friday")); //ビルID
		bill.setBillSat((Integer) map.get("bill_saturday")); //ビルID


		//        owner.setOwnerName((String) map.get("owner_name")); //ビル名
		//        owner.setOwnerTel((String) map.get("owner_tel")); //ビル名

		return bill;
	}

	//ビル情報更新を行う（bchange.html）

	public int updateOne(Bill bill) throws DataAccessException {
		//１件更新
		int rowNumber = jdbcTemplate.update(
				"UPDATE bill"
						+ " SET"
						+ " bill_name = ?,"
						+ " bill_address = ?"
//						+" bill_tel=?,"
//						+" bill_starttime=?,"
//						+" bill_stoptime=?,"
//						+" bill_people=?,"
//						+" bill_sunday=?,"
//						+" bill_monday=?,"
//						+" bill_tuesday=?,"
//						+" bill_wednesday=?,"
//						+" bill_thursday=?,"
//						+" bill_friday=,?"
//						+" bill_saturday=?"
						+ " WHERE bill_id = ?",

						bill.getBillName(),
						bill.getBillAddress(),
						bill.getBillId()
						);

//						bill.getBillTel(),
//						bill.getBillStartTime(),
//						bill.getBillStopTime(),
//				        bill.getBillPeople(),
//				        bill.getBillSun(),
//				        bill.getBillMon(),
//				        bill.getBillTue(),
//				        bill.getBillWed(),
//				        bill.getBillThu(),
//				        bill.getBillFri(),
//				        bill.getBillSat());



		return rowNumber;
	}




	//ビル削除
	public int deleteOne(int billId) throws DataAccessException {

		// billテーブルのデータを削除
		int rowNumber = jdbcTemplate.update("DELETE FROM bill WHERE bill_id = ?", billId);
		return rowNumber;
	}


	//ビル新規登録
	public int insertOne(Bill bill) {

		//１件登録
		int rowNumber = jdbcTemplate.update(
				"INSERT INTO bill("
				+" bill_name,"
				+" bill_address,"
				+" bill_tel,"
				+" bill_starttime,"
				+" bill_stoptime,"
				+" bill_people,"
				+" bill_sunday,"
				+" bill_monday,"
				+" bill_tuesday,"
				+" bill_wednesday,"
				+" bill_thursday,"
				+" bill_friday,"
				+" bill_saturday)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?)",
				bill.getBillName(),
				bill.getBillAddress(),
				bill.getBillTel(),
				bill.getBillStartTime(),
				bill.getBillStopTime(),
		        bill.getBillPeople(),
		        bill.getBillSun(),
		        bill.getBillMon(),
		        bill.getBillTue(),
		        bill.getBillWed(),
		        bill.getBillThu(),
		        bill.getBillFri(),
		        bill.getBillSat());

		return rowNumber;
	}
}
