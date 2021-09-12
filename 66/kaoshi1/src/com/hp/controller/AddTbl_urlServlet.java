package com.hp.controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.bean.Tbl_pur_approval;
import com.hp.service.Tblpur_approvalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "AddTbl_urlServlet",urlPatterns = "/AddTbl_urlServlet")
public class AddTbl_urlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.修正编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        String pId = req.getParameter("pId");
        String paDate=req.getParameter("paDate");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String paState = req.getParameter("paState");
        Date paDate1= null;

        try {
            paDate1 = simpleDateFormat.parse(paDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat.format(paDate1);
            System.out.println("paDate1 = " + paDate1);

        Tbl_pur_approval tbl_pur_approval = new Tbl_pur_approval();
        tbl_pur_approval.setpId(Integer.parseInt(pId));
        tbl_pur_approval.setPaDate(paDate1);
        tbl_pur_approval.setPaState(paState);

        Tblpur_approvalService tblpur_approvalService = new Tblpur_approvalService();
        Map map = tblpur_approvalService.addTbl_url(tbl_pur_approval);
        System.out.println("map = " + map);

        String s = JSONObject.toJSONString(map);
        System.out.println("s = " + s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
