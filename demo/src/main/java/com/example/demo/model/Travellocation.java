package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Travellocation {
    private int location_id;              // 여행 장소 고유 식별자
    private String location_name;         // 장소 이름
    private String country;              // 국가
    private String city;                 // 도시
    private String address;              // 상세 주소
    private String description;          // 상세 설명
    private String category;             // 장소 유형
    private BigDecimal latitude;         // 위도
    private BigDecimal longitude;        // 경도
    private String image_url;             // 이미지 URL
    private LocalDateTime created_at;     // 생성 일시
    private LocalDateTime updated_at;     // 마지막 수정 일시
}