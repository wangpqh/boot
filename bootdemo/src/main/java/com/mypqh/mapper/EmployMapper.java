package com.mypqh.mapper;

import com.mypqh.common.Employ;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface EmployMapper {
    List<Employ> getAll();
    List<Employ> getAllRe();

    Employ getById(String id);
    Employ getByIdCall(String id);
}
