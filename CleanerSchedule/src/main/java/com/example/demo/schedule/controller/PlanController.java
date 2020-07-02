package com.example.demo.schedule.controller;

import java.util.Arrays;
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
import com.example.demo.schedule.domain.model.SelectForm;
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



	//html+で書いたmtop2に飛ぶ
	@GetMapping("/plan/mtop")
	public String getList(Model model) {

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


	//休み申請者を取得する

   @GetMapping("/plan/restlist")
		public String getRestList(Model model) {
			// コンテンツ部分にユーザー詳細を表示するための文字列を登録
 			model.addAttribute("contents", "plan/restlist :: restlist_contents");
			// スタッフ一覧の生成
			try {

 			List<Plan> planList = planService.getRestList();
 			model.addAttribute("planList", planList);
		} catch (NullPointerException e) {

	 		System.out.println("入っていない");

			}

			// homelayout.htmlに画面遷移
			return "homelayout";

   }



  //休み申請の処理(falseになったひとのidを1に書き換えて次の画面に渡す)
		/**
		 * POST用の処理
		 */
		@PostMapping(value="/plan/edit", params ="restcheck")
		public String postDeleatePlan(Model model) {

			//書き換えて返ってきた結果の判定
			boolean result=planService.deleatePlan();

			if(result==true) {
				model.addAttribute("result","変更成功");
			}else {
				model.addAttribute("result","変更失敗");
			}

			// homelayout.htmlに画面遷移
			return getList3(model);

		}


	//schedule,bill.staffのリストを取得
	@GetMapping("/plan/edit")
	public String getList3(Model model) {

		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "plan/edit :: edit_contents");

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

	public String postPlanChangeUpdate(	@ModelAttribute SelectForm selectform, Model model) {

		String select[] = selectform.getSelectForm();
		System.out.println(Arrays.toString(select));
		System.out.println(select[1]);

		try {
			//更新実行
			boolean result = planService.updateOne(selectform);
			if (result == true) {
				model.addAttribute("result", "更新成功");
			} else {
				model.addAttribute("result", "更新失敗");
			}
		} catch (DataAccessException e) {

			model.addAttribute("result", "更新失敗(トランザクションテスト)");
		}

		//mtopに戻る
		return getList(model);
	}

}
