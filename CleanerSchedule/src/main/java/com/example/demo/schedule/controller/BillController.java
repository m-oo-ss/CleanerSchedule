package com.example.demo.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.schedule.domain.model.Bill;
import com.example.demo.schedule.domain.model.Owner;
import com.example.demo.schedule.domain.model.Plan;
import com.example.demo.schedule.domain.model.SignupForm;
import com.example.demo.schedule.domain.service.AlertService;
import com.example.demo.schedule.domain.service.BillService;
import com.example.demo.schedule.domain.service.OwnerService;
import com.example.demo.schedule.domain.service.PlanService;

@Controller
public class BillController {
	@Autowired
	private BillService billService;
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PlanService planService;
	@Autowired
	private AlertService alertService;

//	//サンプルページの表示
//	@GetMapping("/sample")
//	public String getSample(Model model) {
//		model.addAttribute("contents", "sample :: sample_contents");
//
//		// sample.htmlに画面遷移
//		return "homelayout";
//	}

	//ビル一覧の表示
	@GetMapping("/bill/blist")
	public String getBillList(Model model) {
		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "bill/blist :: blist_contents");
		// Stringからint型に変換
		//       int id = Integer.parseInt(str);
		// ビル一覧の生成
		List<Bill> billList = billService.findAll();
		//Modelにユーザーリストを登録
		model.addAttribute("billList", billList);


        //新着件数表示をしたいのですが。保留。
		List<Plan> pList = alertService.getAlertList();
        model.addAttribute("pList",pList.size());
//        System.out.println(pList.size());

		// homelayout.htmlに画面遷移
		return "homelayout";
	}

	//詳細画面に移動
	@GetMapping("/bill/bdetail/{id}")
	public String getDetail(Model model,
			//PathVariableをつけると渡されてきたパス(URL)の値を引数の変数に入れられる
			@PathVariable("id") int billId) {
		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "bill/bdetail :: bdetail_contents");

		//1件検索

		Bill bill = billService.findOne(billId);
		Owner owner = ownerService.findOne(billId);

		List<Plan> planList = planService.findAll();

		// 検索結果をModelに登録
		model.addAttribute("id", bill.getBillId());
		model.addAttribute("name", bill.getBillName());
		model.addAttribute("address", bill.getBillAddress());
		model.addAttribute("owner_name", owner.getOwnerName());
		model.addAttribute("owner_tel", owner.getOwnerTel());
		model.addAttribute("people", bill.getBillPeople());
		model.addAttribute("sun", bill.getBillSun());
		model.addAttribute("mon", bill.getBillMon());
		model.addAttribute("tue", bill.getBillTue());
		model.addAttribute("wed", bill.getBillWed());
		model.addAttribute("thu", bill.getBillThu());
		model.addAttribute("fri", bill.getBillFri());
		model.addAttribute("sat", bill.getBillSat());

		model.addAttribute("planList", planList);

		// homelayout.htmlに画面遷移
		return "homelayout";
	}

	//変更画面に移動
	@GetMapping("/bill/bchange/{id}")
	public String getChange(Model model,
			//PathVariableをつけると渡されてきたパス(URL)の値を引数の変数に入れられる
			@ModelAttribute Bill form, @PathVariable("id") int billId) {

		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "bill/bchange :: bchange_contents");
		//1件検索
		Bill bill = billService.findOne(billId);

		// 検索結果をModelに登録
		model.addAttribute("id", bill.getBillId());	//	ビルId
		model.addAttribute("name", bill.getBillName());//ビル名前
		model.addAttribute("address", bill.getBillAddress());//ビル住所
//		model.addAttribute("owner_name", owner.getOwnerName());//オーナー名
//		model.addAttribute("owner_tel", owner.getOwnerTel());//オーナー電話番号
//		model.addAttribute("people", bill.getBillPeople());//ビルへの派遣人数
//		model.addAttribute("sun", bill.getBillSun());//
//		model.addAttribute("mon", bill.getBillMon());
//		model.addAttribute("tue", bill.getBillTue());
//		model.addAttribute("wed", bill.getBillWed());
//		model.addAttribute("thu", bill.getBillThu());
//		model.addAttribute("fri", bill.getBillFri());
//		model.addAttribute("sat", bill.getBillSat());

		// Billクラスをフォームクラスに変換
		form.setBillId(bill.getBillId()); //ユーザーID
		form.setBillName(bill.getBillName()); //ビル名前
		form.setBillAddress(bill.getBillAddress()); //ビル住所
//		form.setBillTel(bill.getBillTel()); //電話番号
//		form.setOwnerName(owner.getOwnerName()); //オーナー名
//		form.setOwnerTel(owner.getOwnerTel()); //オーナー電話番号
//		form.setBillPeople(bill.getBillPeople());//派遣人数
//		form.setBillSun(bill.getBillSun());//日
//		form.setBillMon(bill.getBillMon());//月
//		form.setBillTue(bill.getBillTue());//火
//		form.setBillWed(bill.getBillWed());//水
//		form.setBillWed(bill.getBillWed());//水
//		form.setBillThu(bill.getBillThu());//
//		form.setBillFri(bill.getBillFri());//
//		form.setBillSat(bill.getBillSat());//
//		form.setBillStartTime(bill.getBillStartTime());
//		form.setBillStopTime(bill.getBillStopTime());


		// Modelに登録
		model.addAttribute("signupForm", form);

		// homelayout.htmlに画面遷移
		return "homelayout";
	}

	//変更を実行
	@PostMapping(value = "/bill/bcomp", params = "update")

	public String postBillChangeUpdate(@ModelAttribute Bill form, Model model) {
		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "bill/bcomp :: bcomp_contents");

		Bill bill = new Bill();
		// フォームクラスをbillクラスに変換 ↑の逆
		bill.setBillId(form.getBillId());
		bill.setBillName(form.getBillName()); //ビル名
		bill.setBillAddress(form.getBillAddress()); //住所
//		bill.setBillTel(form.getBillTel()); //電話番号
//		owner.setOwnerName(form.getOwnerName()); //オーナー名
//		owner.setOwnerTel(form.getOwnerTel()); //オーナー電話番号
//		bill.setBillPeople(form.getBillPeople());//派遣人数
//		bill.setBillPeople(bill.getBillPeople());//派遣人数
//		bill.setBillSun(form.getBillSun());//日
//		bill.setBillMon(form.getBillMon());//月
//		bill.setBillTue(form.getBillTue());//火
//		bill.setBillWed(form.getBillWed());//水
//		bill.setBillWed(form.getBillWed());//水
//		bill.setBillThu(form.getBillThu());//
//		bill.setBillFri(form.getBillFri());//
//		bill.setBillSat(form.getBillSat());//
//		bill.setBillStartTime(form.getBillStartTime());
//		bill.setBillStopTime(form.getBillStopTime());

	try {
			//更新実行
			boolean result = billService.updateOne(bill);
			if (result == true) {
				model.addAttribute("result", "更新成功");
			} else {
				model.addAttribute("result", "更新失敗");
			}
		} catch (DataAccessException e) {

			model.addAttribute("result", "更新失敗(トランザクションテスト)");
		}

		//ビル一一覧画面を表示

		return getBillList(model);
	}

	//削除画面に移動
	@GetMapping("/bill/bdelete/{id}")
	public String getDelete(Model model, //PathVariableをつけると渡されてきたパス(URL)の値を引数の変数に入れられる
			@PathVariable("id") int billId) {

		//1件検索

		Bill bill = billService.findOne(billId);

		// 検索結果をModelに登録
		model.addAttribute("id", bill.getBillId());
		model.addAttribute("name", bill.getBillName());
		model.addAttribute("address", bill.getBillAddress());

		return "bdelete";
	}

	//新規登録画面に移動
	@GetMapping("/bill/bnew")
	public String getNew(@ModelAttribute SignupForm form, Model model) {

		// コンテンツ部分に新規登録を表示するための文字列を登録
		model.addAttribute("contents", "bill/bnew :: bnew_contents");

		Bill bill = new Bill();
		Owner owner = new Owner();
		// Billクラスをフォームクラスに変換
		form.setBillName(bill.getBillName()); //ビル名
		form.setBillAddress(bill.getBillAddress()); //ビル住所
		form.setBillTel(bill.getBillTel()); //電話番号
		form.setOwnerName(owner.getOwnerName()); //オーナー名
		form.setOwnerTel(owner.getOwnerTel()); //オーナー電話番号
		form.setBillPeople(bill.getBillPeople());//派遣人数
		form.setBillSun(bill.getBillSun());//日
		form.setBillMon(bill.getBillMon());//月
		form.setBillTue(bill.getBillTue());//火
		form.setBillWed(bill.getBillWed());//水
		form.setBillThu(bill.getBillThu());//木
		form.setBillFri(bill.getBillFri());//金
		form.setBillSat(bill.getBillSat());//土
		form.setBillStartTime(bill.getBillStartTime());
		form.setBillStopTime(bill.getBillStopTime());

		model.addAttribute("signupForm", form);

		// homelayout.htmlに画面遷移
		return "homelayout";
	}

	//新規登録を行う

	@PostMapping(value = "/bill/bcomp", params = "new")
	public String postNew(@Validated @ModelAttribute SignupForm form,
			Model model, BindingResult bindingResult) {

		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "bill/bcomp :: bcomp_contents");

		// 入力チェックに引っかかった場合、ユーザー登録画面に戻る
		if (bindingResult.hasErrors()) {

			// GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻ります
			return getNew(form, model);
	}

		//ビル、オーナークラスのインスタンス生成
		Bill bill = new Bill();
		Owner owner = new Owner();

		// フォームクラスをbillクラスに変換
		//        bill.setBillId(form.getBillId()); //ユーザーID IDは自動入力
		bill.setBillName(form.getBillName()); //ビル名
		bill.setBillAddress(form.getBillAddress()); //住所
		bill.setBillTel(form.getBillTel()); //電話番号
		owner.setOwnerName(form.getOwnerName()); //オーナー名
		owner.setOwnerTel(form.getOwnerTel()); //オーナー電話番号
		bill.setBillPeople(form.getBillPeople());//派遣人数
		bill.setBillSun(form.getBillSun());//日
		bill.setBillMon(form.getBillMon());//月
		bill.setBillTue(form.getBillTue());//火
		bill.setBillWed(form.getBillWed());//水
		bill.setBillThu(form.getBillThu());//
		bill.setBillFri(form.getBillFri());//
		bill.setBillSat(form.getBillSat());//
		bill.setBillStartTime(form.getBillStartTime());
		bill.setBillStopTime(form.getBillStopTime());

		//登録実行
		boolean result = billService.insert(bill);
		if (result == true) {
			model.addAttribute("result", "登録成功");
		} else {
			model.addAttribute("result", "登録失敗");
		}
		//登録実行
		boolean result2 = ownerService.insert(owner);
		if (result2 == true) {
			model.addAttribute("result", "登録成功");
		} else {
			model.addAttribute("result", "登録失敗");
		}


		//画面遷移
		return getBillList(model);

	}

}
