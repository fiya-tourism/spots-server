package com.fy.spotsserver.mapper;

import com.fy.spotsserver.entity.Spotspicture;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpotspictureMapper {


    int insert(Spotspicture record);

    int insertSelective(Spotspicture record);

    String selectByPrimaryKey(@Param("spotsId") Integer spotsId,
                                    @Param("sequence") Integer sequence);

    int updateByPrimaryKeySelective(Spotspicture record);

    int updateByPrimaryKey(Spotspicture record);


}