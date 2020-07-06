package com.example.demo.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.schedule.domain.model.Plan;
import com.example.demo.schedule.domain.service.AlertService;

@Controller
public class AlertController {

	@Autowired
	private AlertService alertService;

	@GetMapping("/homelayout")
	public String postRestList(Model model) {
	model.addAttribute("contents", "homelayout :: homelayout_contents");

	List<Plan> pList = alertService.getAlertList();
    model.addAttribute("pList",pList.size());
    System.out.println(pList.size());



	return "homelayout";
}
}

