package com.example.demo.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.schedule.domain.model.Bill;
import com.example.demo.schedule.domain.model.Plan;
import com.example.demo.schedule.domain.model.Staff;
import com.example.demo.schedule.domain.service.BillService;
import com.example.demo.schedule.domain.service.PlanService;
import com.example.demo.schedule.domain.service.StaffService;

@Controller
public class PlanController {
	@Autowired
	private BillService billService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private PlanService planService;
	//	@Autowired
	//	private OwnerService ownerService;

	//schedule,bill.staffのリストを取得
	@GetMapping("/plan/mtop_sub")
	public String getList(Model model) {

		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		//	model.addAttribute("contents", "plan/mtop :: mtop_contents");
		// ビル一覧の生成
		List<Bill> billList = billService.findAll();
		List<Staff> staffList = staffService.findAll();
		List<Plan> planList = planService.findAll();
		model.addAttribute("billList", billList);
		model.addAttribute("staffList", staffList);
		model.addAttribute("planList", planList);

		// helloResponseDB.htmlに画面遷移
		//return "homelayout";
		return "plan/mtop_sub";
	}

	//html+で書いたmtop2に飛ぶ
	@GetMapping("/plan/mtop")
	public String getList2(Model model) {

		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
			model.addAttribute("contents", "plan/mtop :: mtop_contents");
		// リストを持ってくる
		List<Bill> billList = billService.findAll();
		List<Staff> staffList = staffService.findAll();
		List<Plan> planList = planService.findAll();
		model.addAttribute("billList", billList);
		model.addAttribute("staffList", staffList);
		model.addAttribute("planList", planList);

		// スケジュール一覧に画面遷移
		return "homelayout";

	}

	//schedule,bill.staffのリストを取得
	@GetMapping("/plan/edit")
	public String getList3(Model model) {


		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "plan/edit :: edit_contents");

		// Stringからint型に変換
		//       int id = Integer.parseInt(str);

		// ビル一覧の生成
		List<Bill> billList = billService.findAll();
		List<Staff> staffList = staffService.findAll();
		List<Plan> planList = planService.findAll();


		//Modelにユーザーリストを登録
		model.addAttribute("billList", billList);
		model.addAttribute("staffList", staffList);
		model.addAttribute("planList", planList);


		// helloResponseDB.htmlに画面遷移
		return "homelayout";
	}

	//変更を実行
	@PostMapping(value = "/plan/mtop", params = "update")

	public String postPlanChangeUpdate(@ModelAttribute Plan form, Model model) {

		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "plan/mtop :: mtop_contents");

		Plan plan = new Plan();
		Bill bill = new Bill();

		// 変更した値をplanクラスにセット
		plan.setBillId(bill.getBillId());//	ビルIdをプランクラスにセット
//		plan.setPlanDate//日付をプランクラスにセット
		plan.setStaffNumber(bill.getBillPeople());//ビル清掃人数をプランクラスにセット

//		plan.setPlanId(form.getPlanId()); //プランID
//		plan.setPlanDate(form.getPlanDate());
//		plan.setStaffName(form.getStaffName()); //従業員名
//		plan.setBillName(form.getBillName());
//		plan.setStaffId(form.getStaffId());
//		plan.setDateId(form.getDateId());
//		plan.setStaffNumber(form.getStaffNumber());
//		plan.setPlanWeek(form.getPlanWeek());
//		plan.setPlanDay(form.getPlanDay());

		try {
			//更新実行
			boolean result = planService.updateOne(plan);
			if (result == true) {
				model.addAttribute("result", "更新成功");
			} else {
				model.addAttribute("result", "更新失敗");
			}
		} catch (DataAccessException e) {

			model.addAttribute("result", "更新失敗(トランザクションテスト)");
		}

		//ビル一一覧画面を表示
		//
		return "homelayout";
	}

}
