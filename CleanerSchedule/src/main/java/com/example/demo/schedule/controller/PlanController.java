package com.example.demo.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
