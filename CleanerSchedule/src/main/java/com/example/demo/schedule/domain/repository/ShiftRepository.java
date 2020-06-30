package com.example.demo.schedule.domain.repository;

//package com.example.demo.trySpring;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class ShiftRepository {
//
//	@Autowired
//	private ShiftRepository shiftRepository;
//
//	//idをもとに1件検索
//	public Shift  findOne(int shiftId) {
//
//		// M_USERテーブルのデータを全件取得
//		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM shift " + "WHERE shift_id = ?", shiftId);
//
//		//Shiftインスタンスの生成
//		Shift shift = new Shift();
//
//		// Shiftインスタンスに取得したデータをセットする
//		shift.setShiftId((int) map.get("shift_id"));
//		shift.setShiftDay((int) map.get("shift_day"));
//		shift.setShiftMon((int) map.get("shift_mon"));
//		shift.setShiftTue((int) map.get("shift_tue"));
//		shift.setShiftWed((int) map.get("shift_wed"));
//		shift.setShiftThr((int) map.get("shift_thr"));
//		shift.setShiftFri((int) map.get("shift_fri"));
//		shift.setShiftSat((int) map.get("shift_sat"));
//		shift.setShiftSun((int) map.get("shift_sun"));
//
//		return shift;
//	}
//
//	//シフト情報更新を行う（schange.html）
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	// 全件取得
//
//	public List<Shift> findAll() {
//		return shiftRepository.findAll();
//	}
//
//		public int updateOne(Shift shift) throws DataAccessException {
//			//１件更新
//			int rowNumber = jdbcTemplate.update(
//
//					"UPDATE shift"
//							+ " SET"
//							+ " shift_id = ?,"
//							+ " shift_day = ?,"
//							+ " shift_mon = ?"
//							+ " shift_tue = ?"
//							+ " shift_wed = ?"
//							+ " shift_thr = ?"
//							+ " shift_fri = ?"
//							+ " shift_sat = ?"
//							+ " shift_sun = ?",
//
//					shift.getShiftId(),
//					shift.getShiftDay(),
//					shift.getShiftMon(),
//					shift.getShiftTue(),
//					shift.getShiftWed(),
//					shift.getShiftThr(),
//					shift.getShiftFri(),
//					shift.getShiftSat(),
//					shift.getShiftSun()
//
//			);
//
//			return rowNumber;
//		}
//
//}