package com.fy.spotsserver.mapper;


import com.fy.spotsserver.Util.PageUtils;
import com.fy.spotsserver.entity.SpotVO;
import com.fy.spotsserver.entity.Spots;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpotsMapper {
    int deleteByPrimaryKey(Integer spotsId);

    void insert(Spots record);

    int insertSelective(Spots record);

    SpotVO selectByPrimaryKey(Integer spotsId);

    int updateByPrimaryKeySelective(Spots record);

    int updateByPrimaryKey(Spots record);


    int deleteupdate(Integer spotId);

    List<SpotVO> SoptSelect();

    List<SpotVO> SoptSelectImg();
}