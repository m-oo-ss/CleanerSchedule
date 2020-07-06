package com.example.demo.schedule.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.schedule.domain.model.Plan;
import com.example.demo.schedule.domain.repository.AlertRepository;

@Service
public class AlertService {

	@Autowired
	 private AlertRepository alertRepository;


	//休み申請者取得

public List<Plan> getAlertList() {

	return alertRepository.getAlerttList();



}
}

