package com.example.demo.schedule.domain.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.schedule.domain.model.Staff;

@Repository
public class StaffRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//idをもとに1件検索
	public Staff findOne(int staffId) {

		// Staffテーブルのデータを全件取得
		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM staff " + "WHERE staff_id = ?", staffId);

		//Staffインスタンスの生成
		Staff staff = new Staff();

		// Staffインスタンスに取得したデータをセットする
		staff.setStaffId((Integer) map.get("staff_id")); //スタッフID
		staff.setStaffName((String) map.get("staff_name")); //スタッフ名
		staff.setStaffAddress((String) map.get("staff_address")); //住所
		staff.setStaffMail((String) map.get("staff_mail"));//スタッフメルアド
		staff.setStaffTel((String) map.get("staff_tel"));//スタッフ電話
		staff.setStaffStart((Date) map.get("staff_start"));//スタッフ勤務開始日
		staff.setStaffStop((Date) map.get("staff_stop"));//辞める日
		//staff.setShiftId((int) map.get("shift_id"));

		return staff;
	}


	//スタッフ情報更新を行う（schange.html）
	public int updateOne(Staff staff) throws DataAccessException {
		//１件更新
		int rowNumber = jdbcTemplate.update(
				"UPDATE staff"
						+ " SET"
						+ " staff_name = ?,"
						+ " staff_address = ?,"
						+ " staff_mail = ?,"
						+ " staff_tel = ?,"
						+ " staff_start = ?,"
						+ " staff_stop = ?"
						+ " WHERE staff_id = ?",
				staff.getStaffName(),
				staff.getStaffAddress(),
				staff.getStaffMail(),
				staff.getStaffTel(),
				staff.getStaffStart(),
				staff.getStaffStop(),
				staff.getStaffId()

		);

		return rowNumber;
	}

	//スタッフ新規登録
	public int insertOne(Staff staff) {

		//１件登録
		int rowNumber = jdbcTemplate.update("INSERT INTO staff("
				+ "staff_name,"
				+ " staff_address,"
				+ " staff_mail, "
				+ " staff_tel, "
				+ " staff_start, "
				+ " staff_stop)"
				+ " VALUES(?, ?, ?, ?, ?, ?)",
				//staff.getStaffId(),
				staff.getStaffName(),
				staff.getStaffAddress(),
				staff.getStaffMail(),
				staff.getStaffTel(),
				staff.getStaffStart(),
				staff.getStaffStop()
		//                  staff.getShiftId()
		);

		return rowNumber;

	}


	//スタッフの名前から複数件の検索
	public List<Staff> findSearch(String StaffName) {
		// Staffテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbcTemplate.queryForList(
				"SELECT * "
						+ "FROM staff"
						+ " WHERE (staff_name LIKE '%" + StaffName + "%')"
						+ "and"
						+"(staff_id is not 1)");

		// 検索結果返却用の変数
		List<Staff> staffList = new ArrayList<Staff>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			//staffクラスのインスタンスの生成
			Staff staff = new Staff();

			// Staffインスタンスに取得したデータをセットする
			staff.setStaffId((Integer) map.get("staff_id"));//スタッフID
			staff.setStaffName((String) map.get("staff_name")); //スタッフ名
			staff.setStaffAddress((String) map.get("staff_address")); //スタッフ住所
			staff.setStaffTel((String) map.get("staff_tel"));//スタッフ電話番号
			//結果返却用のListに追加
			staffList.add(staff);
		}

		return staffList;

	}


	//スタッフの全件検索
	public List<Staff> findAll() {

		//staffテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbcTemplate.queryForList(
				"SELECT*FROM staff "
						+ "WHERE staff_Id is not 1");
		//結果返却用の変数
		List<Staff> staffList = new ArrayList<>();
		//取得したデータを返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			//Staffのインスタンス生成
			Staff staff = new Staff();

			//取得したデータを結果返却用のListに取得したデータをセット
			staff.setStaffId((Integer) map.get("staff_id")); //ID
			staff.setStaffName((String) map.get("staff_name")); //ビル名
			staff.setStaffAddress((String) map.get("staff_address")); //住所
			staff.setStaffMail((String) map.get("staff_mail"));
			staff.setStaffTel((String) map.get("staff_tel"));
			//    staff.setStaffStart((Date) map.get("staff_start"));
			//    staff.setStaffStop((Date) map.get("staff_stop"));
			//    staff.setShiftId((int) map.get("shift_id"));

			//結果返却用のListに追加
			staffList.add(staff);
		}
		return staffList;

	}

}
