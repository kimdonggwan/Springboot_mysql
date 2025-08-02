package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.Travellocation;

//@Mapper
public interface TravellocationMapper {

    // 모든 사용자 조회
    List<Travellocation> findAllTravellocations();

}