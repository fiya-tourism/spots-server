package com.fy.spotsserver.controller;

import com.fy.spotsserver.Util.DataGrid;
import com.fy.spotsserver.Util.PageUtils;
import com.fy.spotsserver.entity.Spots;
import com.fy.spotsserver.service.SpotsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: spots-server
 * @Package: com.fy.spotsserver.controller
 * @ClassName: SpotsController
 * @Author: 彭志新
 * @Description: 控制层
 * @Date: 2019/7/15 14:41
 * @Version: 1.0
 */
@Controller
@RequestMapping("spotsController")
public class SpotsController {

    @Autowired
    private SpotsService spotsService;

    /**
     * 旅游查询
     * @param page
     * @return
     */
    @RequestMapping(value = "soptSelect",method = RequestMethod.GET)
    @ResponseBody
    public DataGrid<Spots> SoptSelect(@RequestParam("page") String page){
        Gson gson = new Gson();
        PageUtils pageUtils = gson.fromJson(page, PageUtils.class);
        return spotsService.SoptSelect(pageUtils);

    }
    /**
     * 旅游根据Id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "SoptIdSelect",method = RequestMethod.GET)
    @ResponseBody
    public Spots SoptIdSelect(@RequestParam("id") Integer id){
        return  spotsService.SoptByIdSelect(id);
    }

    /**
     * 新增
     * @param spot
     */
    @RequestMapping(value = "insertSopt",method = RequestMethod.POST)
    @ResponseBody
    public Integer insertSopt(@RequestParam("spot") String spot){
        Gson gson = new Gson();
        Spots spots = gson.fromJson(spot, Spots.class);
        Integer integer = spotsService.insertSopt(spots);
        System.out.println(integer);
        if (integer==1){
            return 1;
        }
        return 2;
    }

    /**
     * 删除
     * @param SpotsId
     */
    @RequestMapping(value = "deleteSopt",method = RequestMethod.POST)
    @ResponseBody
    public Integer deleteSopt(@RequestParam("SpotsId") Integer SpotsId){
        Integer integer = spotsService.deleteSopt(SpotsId);
        if (integer==1){
            return 1;
        }
        return 2;
    }


}
