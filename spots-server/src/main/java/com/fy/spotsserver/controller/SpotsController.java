package com.fy.spotsserver.controller;


import com.fy.spotsserver.Util.DataGrid;
import com.fy.spotsserver.Util.PageUtils;
import com.fy.spotsserver.entity.SpotVO;
import com.fy.spotsserver.entity.Spots;
import com.fy.spotsserver.entity.Spotspicture;
import com.fy.spotsserver.service.SpotsService;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private static final String PAHT_NAME="http://localhost:8011";

    @Autowired
    private SpotsService spotsService;

    /**
     * 旅游查询
     * @param page
     * @return
     */
    @RequestMapping(value = "soptSelect",method = RequestMethod.GET)
    @ResponseBody
    public DataGrid<SpotVO> SoptSelect(@RequestParam("page") String page){
        Gson gson = new Gson();
        PageUtils pageUtils = gson.fromJson(page, PageUtils.class);
        DataGrid dataGrid = spotsService.SoptSelect(pageUtils);
        List<SpotVO> rows = dataGrid.getRows();
        for (SpotVO li : rows) {
            Integer spotsId = li.getSpotsId();
            String soptSelectImg = spotsService.SoptSelectImg(spotsId, 1);
            System.out.println(soptSelectImg);
            li.setPictureUrl(PAHT_NAME+soptSelectImg);
        }
            return dataGrid;
        }

    /**
     * 旅游根据Id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "SoptIdSelect",method = RequestMethod.GET)
    @ResponseBody
    public SpotVO SoptIdSelect(@RequestParam("id") Integer id){
        return  spotsService.SoptByIdSelect(id);
    }
    /**
     * 旅游根据Id查询带图片
     * @param id
     * @return
     */
    @RequestMapping(value = "SoptIdSelectImg",method = RequestMethod.GET)
    @ResponseBody
    public SpotVO SoptIdSelectImg(@RequestParam("id") Integer id){
        SpotVO spots = spotsService.SoptByIdSelect(id);
        String spotVO = spotsService.SoptByIdSelectImg(spots.getSpotsId());
        spots.setPictureUrl(PAHT_NAME+spotVO);
        return spots;
    }

    /**
     * 新增
     * @param Spotostr
     * @param spotspictures
     */
    @RequestMapping(value = "insertSopt",method = RequestMethod.POST)
    @ResponseBody
    public Integer insertSopt(@RequestParam("Spotostr") String Spotostr,@RequestParam("spotspictures") String spotspictures){
        Gson gson = new Gson();
        Spots spots = gson.fromJson(Spotostr, Spots.class);
        Spotspicture spotspicture = gson.fromJson(spotspictures, Spotspicture.class);
        Integer integer = spotsService.insertSopt(spots,spotspicture);
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
