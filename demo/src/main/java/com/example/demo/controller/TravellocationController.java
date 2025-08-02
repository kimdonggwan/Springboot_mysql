package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Travellocation;
import com.example.demo.service.TravellocationService;

@RestController
@RequestMapping("/api/travellocations") // 이 컨트롤러의 기본 경로
@CrossOrigin(origins = "http://localhost:3000") // React 개발 서버의 주소
public class TravellocationController {

    @Autowired
    private TravellocationService travellocationService;

    // 모든 사용자 조회 (GET /api/travellocations)
    @GetMapping
    public List<Travellocation> getAllTravellocations() {
        return travellocationService.getAllTravellocations();
    }

}