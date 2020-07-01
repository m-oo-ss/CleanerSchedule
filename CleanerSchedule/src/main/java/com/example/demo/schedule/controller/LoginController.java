package com.example.demo.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.schedule.domain.model.Staff;
import com.example.demo.schedule.domain.service.LoginService;

@Controller
public class LoginController {
@Autowired
    private LoginService loginService;
   /**
     * ログイン画面のGETメソッド用処理.
     */
    @GetMapping("/login")
    public String getLogin(Model model) {

        //login.htmlへ画面遷移
        return "login";
    }

    /**
     * POST用の処理（DB）.
     */

    @PostMapping("/sample")
    public String postDbRequest(@RequestParam("staffname") String name, @RequestParam("staffpass") String pass,Model model) {


 // コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "sample :: sample_contents");


 // コンテンツ部分にユーザー詳細を表示するための文字列を登録

        if(name == "" || pass == "") {
        return "login";
        }

        // １件検索
        Staff staff = loginService.findOne(name,pass);

        // 検索結果をModelに登録
        model.addAttribute("id", staff.getStaffId());
        model.addAttribute("name", staff.getStaffName());
        model.addAttribute("address", staff.getStaffAddress());
        model.addAttribute("mail", staff.getStaffMail());
        model.addAttribute("tel", staff.getStaffTel());
        model.addAttribute("pass",staff.getStaffPass());

        int id = staff.getStaffId();

        if(id == 1) {
        // mdetail.html(管理側スケジュール詳細)に画面遷移
        return "homelayout";

        }else
        // sdetail.html(従業員側スケジュール詳細)に画面遷移
        return "homelayout";
    }




}


