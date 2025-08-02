
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.TravellocationMapper;
import com.example.demo.model.Travellocation;

@Service
public class TravellocationService {

	@Autowired
    private TravellocationMapper travellocationMapper;

    public List<Travellocation> getAllTravellocations() {
    
        return travellocationMapper.findAllTravellocations();
    }

}