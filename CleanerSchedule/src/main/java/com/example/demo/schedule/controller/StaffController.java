package com.example.demo.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.schedule.domain.model.Plan;
import com.example.demo.schedule.domain.model.Staff;
import com.example.demo.schedule.domain.model.StaffForm;
import com.example.demo.schedule.domain.service.AlertService;
import com.example.demo.schedule.domain.service.PlanService;
import com.example.demo.schedule.domain.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	@Autowired
	private PlanService planService;
	@Autowired
	private AlertService alertService;

	//スタッフの最初のページを表示、
	@GetMapping("/staff/ssearch")

	public String getSearch(@ModelAttribute StaffForm form, Model model) {

		model.addAttribute("contents", "staff/ssearch :: ssearch_contents");
		// Modelに登録
	//	model.addAttribute("Staff", form);
		// Staff一覧の生成
		List<Staff> staffList = staffService.findAll();
		//Modelにstaffリストを登録
		model.addAttribute("staffList", staffList);


        //新着件数表示をしたい。ただし一括で表示ができないので個別にいれて保留。
		List<Plan> pList = alertService.getAlertList();
        model.addAttribute("pList",pList.size());
        //System.out.println(pList.size());


		// homelayout.htmlに画面遷移
		return "homelayout";

	}

	//名前から検索してstaffの表示
	/**
	 * POST用の処理
	 */
	@PostMapping("/staff/slist")
	public String postDbRequest(Model model, @RequestParam("search") String StaffName) {
		// コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "staff/slist :: slist_contents");
		// スタッフ一覧の生成
		List<Staff> staffList = staffService.findSearch(StaffName);
		// 検索結果をModelに登録
		model.addAttribute("staffList", staffList);
		// homelayout.htmlに画面遷移
		return "homelayout";

	}



	//1件検索

	@GetMapping("/staff/schange/{id}")

	public String getChange(Model model,

			//PathVariableをつけると渡されてきたパス(URL)の値を引数の変数に入れられる

			@ModelAttribute StaffForm form, @PathVariable("id") int staffId) {

		model.addAttribute("contents", "staff/schange :: schange_contents");

		Staff staff = staffService.findOne(staffId);

		// 検索結果をModelに登録

		model.addAttribute("id", staff.getStaffId());
		model.addAttribute("name", staff.getStaffName());
		model.addAttribute("address", staff.getStaffAddress());
		model.addAttribute("mail", staff.getStaffMail());
		model.addAttribute("tel", staff.getStaffTel());
		model.addAttribute("start", staff.getStaffStart());
		model.addAttribute("stop", staff.getStaffStop());

		//model.addAttribute("shiftid", staff.getShiftId());

		// Staffクラスをフォームクラスに変換

		    form.setStaffId(staff.getStaffId()); //従業員ID

	        form.setStaffName(staff.getStaffName()); //従業員名

            form.setStaffAddress(staff.getStaffAddress()); //住所

	        form.setStaffMail(staff.getStaffMail());//メールアドレス

	        form.setStaffTel(staff.getStaffTel());//電話番号

	        form.setStaffStart(staff.getStaffStart());//勤務開始日

	        form.setStaffStop(staff.getStaffStop());//辞める日

		//form.setShiftId(staff.getShiftId());

		// Modelに登録
//		 model.addAttribute("signupForm", form);

		// schange.htmlに画面遷移
		return "homelayout";

	}



	//情報の更新（変更）
	@PostMapping(value = "/staff/scomp", params = "update")

	public String postBillChangeUpdate(@ModelAttribute StaffForm form, Model model) {

		model.addAttribute("contents", "staff/scomp :: scomp_contents");

		Staff staff = new Staff();

		// フォームクラスをStaffクラスに変換
		staff.setStaffId(form.getStaffId()); //従業員ID
		staff.setStaffName(form.getStaffName()); //従業員名
		staff.setStaffAddress(form.getStaffAddress()); //住所
		staff.setStaffMail(form.getStaffMail()); //メールアドレス
		staff.setStaffTel(form.getStaffTel()); //電話番号
		staff.setStaffStart(form.getStaffStart()); //勤務開始日
		staff.setStaffStop(form.getStaffStop()); //勤務終了日

	   //staff.setShiftId(form.getShiftId()); //シフトID

		try {
			//更新実行
			boolean result = staffService.updateOne(staff);

			if (result == true) {
				model.addAttribute("result", "更新成功");
			} else {
				model.addAttribute("result", "更新失敗");
			}
		} catch (DataAccessException e) {
			model.addAttribute("result", "更新失敗(トランザクションテスト)");
		}
		//scompに遷移

		//

		return getSearch(form,model);

	}
	//    //チェックボタン用変数

	//    private Map<String, String> checkShiftId;

	//

	//    /**    * チェックボタンの初期化メソッド.  */

	//    private Map<String, String> initCheckShiftId() {

	//

	//        Map<String, String> check = new LinkedHashMap<>();

	//

	//        // 月火水木金土日をMapに格納 .put(キー名, 値);

	//        check.put("key_mon", "1");

	//        check.put("key_tue", "1");

	//        check.put("key_wed", "1");

	//        check.put("key_thr", "1");

	//        check.put("key_fri", "1");

	//        check.put("key_sat", "1");

	//        check.put("key_sun", "1");

	//

	//        return check;

	//    }

	//新規登録画面に移動
	@GetMapping("/staff/snew")
	public String getNew(Model model, @ModelAttribute StaffForm form) {

		//コンテンツ部分に新規登録を表示させるための文字列
		model.addAttribute("contents", "staff/snew :: snew_contents");

		//        // チェックボタンの初期化メソッド呼び出し
		//         checkShiftId = initCheckShiftId();
		//
		//     // チェックボタン用のMapをModelに登録
		//        model.addAttribute("checkShiftId", checkShiftId)

		// homelayout.htmlに画面遷移
		return "homelayout";

	}

	//最終確認画面に移動（登録を実行）

	@PostMapping(value = "/staff/scomp", params = "new")
	public String postStaffNew(@ModelAttribute StaffForm form, Model model) {
		model.addAttribute("contents", "staff/scomp:: scomp_contents");

		Staff staff = new Staff();
		// フォームクラスをstaffクラスに変換
//      staff.setStaffId(form.getStaffId()); //従業員ID
		staff.setStaffName(form.getStaffName()); //従業員名
		staff.setStaffAddress(form.getStaffAddress()); //従業員住所
		staff.setStaffMail(form.getStaffMail()); //従業員メールアドレス
		staff.setStaffTel(form.getStaffTel()); //従業員電話番号
		staff.setStaffStart(form.getStaffStart()); //従業員勤務可能開始日
		staff.setStaffStop(form.getStaffStop()); //従業員勤務終了日
   //   staff.setShiftId(form.getShiftId()); //従業員シフトパターン

		//登録実行
		boolean result = staffService.insertOne(staff);

		if (result == true) {
			model.addAttribute("result", "登録成功");
		} else {
			model.addAttribute("result", "登録失敗");

		}
		//画面遷移
		return getSearch(form,model);
	}





    //詳細画面に移動
    @GetMapping("/staff/sdetail/{id}")
    public String getDetail(Model model,
            //PathVariableをつけると渡されてきたパス(URL)の値を引数の変数に入れられる
            @PathVariable("id") int staffId) {
        // コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "staff/sdetail :: sdetail_contents");

        //1件検索

        Staff staff = staffService.findOne(staffId);


		List<Plan> planList = planService.findAll();

        // 検索結果をModelに登録
        model.addAttribute("id", staff.getStaffId());
        model.addAttribute("name", staff.getStaffName());
        model.addAttribute("address", staff.getStaffAddress());

		model.addAttribute("planList", planList);


        // sdetail.htmlに画面遷移
        return "homelayout";
    }

    //個人詳細画面に移動
    @GetMapping("/user/udetail/{pid}")
    public String getUdetail(Model model,
            //PathVariableをつけると渡されてきたパス(URL)の値を引数の変数に入れられる
            @PathVariable("pid") int planId) {
        // コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "user/udetail :: udetail_contents");

        //1件検索
  //      PlanService planService = new PlanService();
        Plan plan = planService.findOne(planId);


        // 検索結果をModelに登録
        model.addAttribute("pid", plan.getPlanId());
//        model.addAttribute("date", plan.getPlanDate());
//        model.addAttribute("bid", plan.getBillId());
        model.addAttribute("sid", plan.getStaffId());
        model.addAttribute("sname", plan.getStaffName());
        model.addAttribute("bname", plan.getBillName());
        model.addAttribute("starttime", plan.getBillStartTime());
        model.addAttribute("stoptime", plan.getBillStopTime());
        model.addAttribute("billmap",plan.getBillMap());
  //      model.addAttribute("check", plan.isRestCheck());




        // sdetail.htmlに画面遷移
        return "homelayout";

    }

    //Planテーブルのrest_checkをfalseに変換する
    @PostMapping(value = "/staff/sdetail/{sid}/{pid}")

    public String postUpdateFalse(Model model,Plan plan,@PathVariable("sid") int staffId,@PathVariable("pid")int planId) {

//    	System.out.println(planId);

    	//変換の実行・変換結果の判定
		boolean result = planService.updateFalse(planId);

		if (result == true) {
			model.addAttribute("result", "登録成功");
		} else {
			model.addAttribute("result", "登録失敗");

		}
			//従業員トップに移動
			return getDetail(model,staffId);

    }

}


