package com.hp.dao;

import com.hp.bean.Tbl_purchase;
import com.hp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//采购表
public class TblpurchaseDao {
    public List<Map> selectAllTb(Map map){
        System.out.println("map dao= " + map);
        for (Object o : map.keySet()) {
            System.out.println("o = " + o);
        }
        //1.开连接
        Connection connection = DBHelper.getConnection();
        List lists=new ArrayList();
        //2.写sql
        String sql="select t1.*,t2.paDate,t2.paState from tbl_purchase as t1 join tbl_pur_approval as t2 on t1.pId=t2.pId";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            //4.执行sql
            rs = ps.executeQuery();
            while (rs.next()){
                Map dataMap=new HashMap();
                dataMap.put("pId",rs.getInt("pId"));
                dataMap.put("pType",rs.getString("pType"));
                dataMap.put("pName",rs.getString("pName"));
                dataMap.put("pUnit",rs.getString("pUnit"));
                dataMap.put("pNum",rs.getInt("pNum"));
                dataMap.put("pPerson",rs.getString("pPerson"));
                dataMap.put("paDate",rs.getString("paDate"));
                dataMap.put("paState",rs.getString("paState"));
                lists.add(dataMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lists;
    }

    //模糊查询
    public List<Map> likePname(Map map){
        String pName = (String) map.get("pName");
        //1.开连接
        Connection connection = DBHelper.getConnection();
        List lists=new ArrayList();
        //2.写sql
        String sql="select t1.*,t2.paDate,t2.paState from tbl_purchase as t1 join tbl_pur_approval as t2 on t1.pId=t2.pId where 1=1";
        if(null!=pName&&pName.length()>0){
            sql=sql+" and t1.pName like '%"+pName+"%'    ";
        }
        System.out.println(" dao de limit sql = " + sql);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            //4.执行sql
            rs = ps.executeQuery();
            while (rs.next()){
                Map dataMap=new HashMap();
                dataMap.put("pId",rs.getInt("pId"));
                dataMap.put("pType",rs.getString("pType"));
                dataMap.put("pName",rs.getString("pName"));
                dataMap.put("pUnit",rs.getString("pUnit"));
                dataMap.put("pNum",rs.getInt("pNum"));
                dataMap.put("pPerson",rs.getString("pPerson"));
                dataMap.put("paDate",rs.getString("paDate"));
                dataMap.put("paState",rs.getString("paState"));
                lists.add(dataMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lists;
    }

    //新增
    public int addTbl(Tbl_purchase tbl) {
        //第1：创建链接对象
        Connection connection = DBHelper.getConnection();
        //第2：sql语句，因为添加的是数据变量 所以用问号代替
        String sql = "insert into tbl_purchase values(null,?,?,?,?,?)";
        //第3：预编译sql
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, tbl.getpType());
            ps.setString(2, tbl.getpName());
            ps.setString(3, tbl.getpUnit());
            ps.setInt(4, tbl.getpNum());
            ps.setString(5, tbl.getpPerson());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
    public static void main(String[] args) {
        TblpurchaseDao tbl_purchaseDao = new TblpurchaseDao();
       /* //全查
        Map paramMap = new HashMap();
        List<Map> maps = tbl_purchaseDao.selectAllTb(paramMap);
        System.out.println("maps = " + maps);
        System.out.println("maps.size() = " + maps.size());*/

      /*  Map paramMap = new HashMap();
        paramMap.put("pName","笔记本");
        List<Map> maps = tbl_purchaseDao.likePname(paramMap);
        System.out.println("maps = " + maps);
        System.out.println("maps.size() = " + maps.size());*/

        Tbl_purchase tbl = new Tbl_purchase();
        tbl.setpType("办公用品");
        tbl.setpName("aa纸");
        tbl.setpUnit("张三");
        tbl.setpNum(20);
        tbl.setpPerson("小黑");
        int i= tbl_purchaseDao.addTbl(tbl);
        System.out.println("i = " + i);

    }

}
