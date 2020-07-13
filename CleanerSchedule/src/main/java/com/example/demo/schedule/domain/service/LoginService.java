package com.example.demo.schedule.domain.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.schedule.domain.model.Staff;
import com.example.demo.schedule.domain.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;

	public Staff findOne(String name, String pass) {

		// １件検索実行
		Map<String, Object> map = loginRepository.findOne(name, pass);

		if(map != null) {
		// Mapから値を取得
			int staffId = (Integer) map.get("staff_id");
			String staffName = (String) map.get("staff_name");
			String staffPass = (String) map.get("staff_pass");


			if (pass.equals(staffPass)) {

				Staff staff = new Staff();

				staff.setStaffId(staffId);
				staff.setStaffName(staffName);
				staff.setStaffPass(staffPass);

				return staff;
			}else {
			System.out.println("パスワードの不一致\n入力パスワード:"+ pass);
			return null;
			}
		}else {
			System.out.println("該当名なし");

		return null;

		}

	}

}
