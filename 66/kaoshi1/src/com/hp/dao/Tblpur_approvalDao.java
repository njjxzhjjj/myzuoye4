package com.hp.dao;

import com.hp.bean.Tbl_pur_approval;
import com.hp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Tblpur_approvalDao {
    //新增
    public int addTbl_url(Tbl_pur_approval tbl_pur_approval) {
        //第1：创建链接对象
        Connection connection = DBHelper.getConnection();
        //第2：sql语句，因为添加的是数据变量 所以用问号代替
        String sql = "insert into tbl_pur_approval values(null,?,?,?)";
        //第3：预编译sql
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, tbl_pur_approval.getpId());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(tbl_pur_approval.getPaDate());
            ps.setString(2,format);
            ps.setString(3, tbl_pur_approval.getPaState());
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
}
