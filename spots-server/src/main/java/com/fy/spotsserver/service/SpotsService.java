package com.fy.spotsserver.service;

import com.fy.spotsserver.Util.DataGrid;
import com.fy.spotsserver.Util.PageUtils;
import com.fy.spotsserver.entity.SpotVO;
import com.fy.spotsserver.entity.Spots;
import com.fy.spotsserver.entity.Spotspicture;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: spots-server
 * @Package: com.fy.spotsserver.service
 * @ClassName: SpotsService
 * @Author: 彭志新
 * @Description: 接口
 * @Date: 2019/7/15 14:42
 * @Version: 1.0
 */
public interface SpotsService {

    DataGrid SoptSelect(PageUtils page);

    Integer insertSopt(Spots spots, Spotspicture spotspicture);

    SpotVO SoptByIdSelect(Integer spotsId);

    Integer deleteSopt(Integer spotsId);

    String SoptSelectImg( Integer spotsId,Integer sequence);


    String SoptByIdSelectImg(Integer id);
}
