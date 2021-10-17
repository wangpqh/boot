package com.mypqh.service;

import com.mypqh.common.Employ;
import com.mypqh.mapper.EmployMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {
    @Autowired
    EmployMapper employMapper;

    public List<Employ> getAllEmploy() {
//        return employMapper.getAll();
        return employMapper.getAllRe();
    }

    public Employ getOne(String id){
        return employMapper.getById(id);
    }
}
