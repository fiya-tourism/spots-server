package com.fy.spotsserver.mapper;


import com.fy.spotsserver.service.Spots;

public interface SpotsMapper {
    int deleteByPrimaryKey(Integer spotsId);

    int insert(Spots record);

    int insertSelective(Spots record);

    Spots selectByPrimaryKey(Integer spotsId);

    int updateByPrimaryKeySelective(Spots record);

    int updateByPrimaryKey(Spots record);
}