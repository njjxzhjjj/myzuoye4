package com.hp.service;

import com.hp.bean.Tbl_pur_approval;
import com.hp.dao.Tblpur_approvalDao;

import java.util.HashMap;
import java.util.Map;

public class Tblpur_approvalService {
    //添加
    public Map addTbl_url(Tbl_pur_approval tbl_pur_approval) {
        System.out.println("进入到 service 层了---");
        Map map = new HashMap();
        Tblpur_approvalDao dao = new Tblpur_approvalDao();
        int i = dao.addTbl_url(tbl_pur_approval);
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
