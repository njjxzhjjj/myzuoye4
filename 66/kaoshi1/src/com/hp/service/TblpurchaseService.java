package com.hp.service;

import com.hp.bean.Tbl_purchase;
import com.hp.dao.TblpurchaseDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TblpurchaseService {
    //全查
    public Map tbl_purchaseService(Map map1){
        TblpurchaseDao dao = new TblpurchaseDao();
        List<Map> maps = dao.selectAllTb(map1);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("data",maps);
        codeMap.put("msg","ok");
        return  codeMap;
    }

    public Map likePname(Map map){
        TblpurchaseDao dao = new TblpurchaseDao();
        List<Map> maps = dao.likePname(map);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("data",maps);
        codeMap.put("msg","ok");
        return  codeMap;
    }
    //添加
    public Map addTbl(Tbl_purchase tbl) {
        System.out.println("进入到 service 层了---");
        Map map = new HashMap();
        TblpurchaseDao dao = new TblpurchaseDao();
        int i = dao.addTbl(tbl);
        System.out.println("i = " + i);
        if (i == 1) {
            map.put("code", 0);
            map.put("msg", "添加成功");
        } else {
            map.put("code", 400);
            map.put("msg", "添加不成功");
        }
        return map;
    }
}
