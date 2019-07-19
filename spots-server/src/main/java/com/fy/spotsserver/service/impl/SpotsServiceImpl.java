package com.fy.spotsserver.service.impl;

import com.fy.spotsserver.Util.DataGrid;
import com.fy.spotsserver.Util.PageUtils;
import com.fy.spotsserver.entity.Spots;
import com.fy.spotsserver.mapper.SpotsMapper;
import com.fy.spotsserver.service.SpotsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mongodb.client.result.DeleteResult;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: spots-server
 * @Package: com.fy.spotsserver.service
 * @ClassName: SpotsService
 * @Author: 彭志新
 * @Description: 接口
 * @Date: 2019/7/15 14:42
 * @Version: 1.0
 */
@Service
public class SpotsServiceImpl implements SpotsService {
    @Autowired
    private SpotsMapper spotsMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    // mongodb 数据库名
    private static final String MDB_NAME= "Spot";
    private static final String WH_NAME= "号景点";


    @Override
    public DataGrid SoptSelect(PageUtils page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<Spots> soptSelect= spotsMapper.SoptSelect(page.getPostId());
        PageInfo<Spots> pageInfo=new PageInfo<>(soptSelect);
        DataGrid<Spots> dataGrid=new DataGrid<Spots>();
        dataGrid.setRows(soptSelect);
        dataGrid.setTotal(pageInfo.getTotal());
        return dataGrid;
    }


    @Override
    public Spots SoptByIdSelect(Integer spotsId) {
        Spots spots = spotsMapper.selectByPrimaryKey(spotsId);
        String selectcontent = Selectcontent(spotsId);

        spots.setConentisert(selectcontent);
        return spots;
    }

    public String Selectcontent(Integer SpotsId){
        Query query = Query.query(Criteria.where("spotsIntroduceId").is(SpotsId+WH_NAME));
        List<Spots> spotsList = this.mongoTemplate.find(query, Spots.class);
        for (Spots spots: spotsList) {
            return  spots.getConentisert();
        }
        return  null;
    }

    /**
     * 景点添加
     * @param spots
     */
    @Override
    public Integer insertSopt(Spots spots) {
        if (spots.getSpotsId()!=null){
            spots.setSpotsUpdate(new Date());
            spots.setSpotsYn(0);
            Integer i = spotsMapper.updateByPrimaryKey(spots);
            if (i!=null){
                Integer updatecontent = updatecontent(spots);
                if (updatecontent==1){
                    return 1;
                }
            }
        return 2;
    }
        spots.setSpotsCreate(new Date());
        spots.setSpotsYn(0);
        spotsMapper.insert(spots);
        Integer insert = spots.getSpotsId();
        if (insert!=null){
            Spots pos = new Spots();
            pos.setSpotsIntroduceId(insert+WH_NAME);
            pos.setConentisert(spots.getConentisert());
            Integer insertcontent = insertcontent(pos);
            if (insertcontent==1){
                return 1;
            }
        }
        return 2;
    }
    public Integer insertcontent(Spots spots1){
        Spots insert = this.mongoTemplate.insert(spots1);
        if (insert !=null){
            return 1;
        }
        return 2;
    }

    public Integer updatecontent(Spots spots1){
        Query query = Query.query(Criteria.where("spotsIntroduceId").is(spots1.getSpotsId()+WH_NAME));
        if (query!=null){
            Update update =new Update().set("conentisert",spots1.getConentisert())
                    .set("spotsActivity",spots1.getSpotsActivity());
            mongoTemplate.updateFirst(query,update,spots1.getClass());
            if (update!=null){
                return 1;
            }
        }
        return 2;
    }

    @Override
    public Integer deleteSopt(Integer spotsId) {

        Integer i = spotsMapper.deleteupdate(spotsId);
        if (i!=0){
            Query query =new Query(Criteria.where("spotsIntroduceId").is(spotsId+WH_NAME));
            //new Query(Criteria.where("spotsIntroduceId").is(spotsId+WH_NAME))
            DeleteResult remove = mongoTemplate.remove(query, Spots.class);
            if (remove!=null){
                return 1;
            }
        }
        return 2;
    }


}

