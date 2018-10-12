package com.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/ExUrl1")
public class ExUrl1 extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String mat1_name=req.getParameter("mat1_name");
        String mat1_price=req.getParameter("mat1_price");
        String mat1_quantity=req.getParameter("mat1_quantity");
        String mat2_name=req.getParameter("mat2_name");
        String mat2_price=req.getParameter("mat2_price");
        String mat2_quantity=req.getParameter("mat2_quantity");
        PrintWriter out=resp.getWriter();
        out.println(mat1_name+" "+mat1_price+" "+mat1_quantity);
        out.println(mat2_name+" "+mat2_price);
        out.println("<a href=ExUrl2?mat1_name="+mat1_name+"&mat1_price="+mat1_price+"&mat1_quantity="+mat1_quantity+">click here to get total cost of material 1</a>");
        out.println("<a href=ExUrl3?mat2_name="+mat2_name+"&mat2_price="+mat2_price+"&mat2_quantity="+mat2_quantity+">click here to get total cost of material 2</a>");
	    
    }

}
