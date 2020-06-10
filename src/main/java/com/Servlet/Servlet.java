package com.Servlet;

import dao2.GoodDAO;
import pojo2.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/goods.do")
public class Servlet extends HttpServlet {
    private GoodDAO goodsDAO=new GoodDAO();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("p");
        if("fenye".equals(p)){
            doFenYe(request , response);
        }

        if("findbyid".equals(p)){
            doFindById(request , response);
        }
        if ("addCar".equals(p)){
            doAddCar(request,response);
        }
        if("addcarnum".equals(p)){
            doAddCarNum(request,response);
        }
    }

    private void doAddCarNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsid = request.getParameter("goodsid");
        Goods goods = goodsDAO.findbyid(goodsid);

        Map map = (Map) request.getSession().getAttribute("map");
        Integer num = (Integer) map.get(goods);
        map.put(goods,num+1);
        response.sendRedirect("showCar.jsp");
    }

    private void doAddCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsid = request.getParameter("goodsid");
        int num = Integer.parseInt(request.getParameter("num"));

        Goods goods = goodsDAO.findbyid(goodsid);

        HttpSession session= request.getSession();
        Map<Goods,Integer> map =(Map) session.getAttribute("map");

        if (map==null){
            map = new HashMap<Goods,Integer>();
        }
        Integer n = map.get(goods);
        if (n==null){
            map.put(goods,num);
        }else {
            map.put(goods,n+num);
        }
        session.setAttribute("map",map);
        response.sendRedirect("showCar.jsp");

    }

    private void doFindById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");

        Goods goods=goodsDAO.findbyid(goodsid);

        request.setAttribute("goods" , goods);
        request.getRequestDispatcher("showDetail.jsp").forward(request , response);

    }

    private void doFenYe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageString = request.getParameter("page");
        String sizeString = request.getParameter("size");

        int page = 1;
        int size = 4;

        if(pageString!=null && pageString.trim().length()>0){
            page = Integer.parseInt(pageString);
        }

        if (sizeString!=null && sizeString.trim().length()>0){
            size = Integer.parseInt(sizeString);
        }

        if (page<1){
            page = 1;
        }

        //得到总条数
        int count = goodsDAO.getCount();
        int pagecount = count % size == 0 ? count / size : count / size + 1;
        if (page>pagecount){
            page = pagecount;
        }

        List<Goods> list = goodsDAO.findall(page, size);

        Map map = new HashMap<>();
        map.put("page",page);
        map.put("size",size);
        map.put("count",count);
        map.put("pagecount",pagecount);
        map.put("list",list);

        request.setAttribute("map",map);
        request.getRequestDispatcher("show.jsp").forward(request,response);

    }
}
