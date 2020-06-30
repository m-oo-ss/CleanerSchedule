package com.example.demo.schedule.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.schedule.domain.model.Owner;

@Repository
public class OwnerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//    public List<Bill> findAll() {
	//
	//        // M_USERテーブルのデータを全件取得
	//        List<Map<String, Object>> getList = jdbcTemplate.queryForList("SELECT * FROM bill");
	//
	//        // 結果返却用の変数
	//        List<Bill> billList = new ArrayList<>();
	//
	//        // 取得したデータを結果返却用のListに格納していく
	//        for (Map<String, Object> map : getList) {
	//
	//            //Billインスタンスの生成
	//            Bill bill = new Bill();
	//
	//            // Billインスタンスに取得したデータをセットする
	//            bill.setBillId((Integer) map.get("bill_id")); //ビルID
	//            bill.setBillName((String) map.get("bill_name")); //ビル名
	//
	//            //結果返却用のListに追加
	//            billList.add(bill);
	//        }
	//
	//idをもとに1件検索
	public Owner findOne(int billId) {

		//ownerテーブルのデータを1件取得
		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT"
				+ " owner.owner_id,"
				+ " owner.owner_name,"
				+ " owner.owner_tel"
				+ " FROM bill  INNER JOIN" +
				" owner " +
				" ON" +
				" bill.owner_id = owner.owner_id" + " WHERE bill_id = ?", billId);

		//Billインスタンスの生成
		//        Bill bill = new Bill();
		//Ownerインスタンスの生成
		Owner owner = new Owner();

		//        // Billインスタンスに取得したデータをセットする
		//        bill.setBillId((Integer) map.get("bill_id")); //ビルID
		//        bill.setBillName((String) map.get("bill_name")); //ビル名
		//        bill.setBillAddress((String) map.get("bill_address")); //住所

		//ownerインスタンスに取得したデータをセットする
		owner.setOwnerName((String) map.get("owner_name")); //オーナー名
		owner.setOwnerTel((String) map.get("owner_tel")); //オーナー電話

		return owner;
	}
	//
	//    //ビル情報更新を行う（bchange.html）
	//
	//    public int updateOne(Owner owner) throws DataAccessException {
	//        //１件更新
	//        int rowNumber = jdbcTemplate.update(
	//                "UPDATE bill"
	//                        + " SET"
	//                        + " bill_name = ?,"
	//                        + " bill_address = ?"
	//                        + " WHERE bill_id = ?",
	//                owner.getBillName(),
	//                owner.getBillAddress(),
	//                owner.getBillId()
	//
	//        );
	//
	//        return rowNumber;
	//    }
	//
	//    //ビル削除
	//    public int deleteOne(int billId) throws DataAccessException {
	//
	//        // billテーブルのデータを削除
	//        int rowNumber = jdbcTemplate.update("DELETE FROM bill WHERE bill_id = ?", billId);
	//        return rowNumber;
	//    }

	//オーナー新規登録
	public int insertOne(Owner owner) {

		//１件登録
		int rowNumber = jdbcTemplate.update("INSERT INTO owner("
				+ " owner_name,"
				+ " owner_tel)"
				+ " VALUES(?, ?)",
				owner.getOwnerName(),
				owner.getOwnerTel());

		return rowNumber;
	}

}
