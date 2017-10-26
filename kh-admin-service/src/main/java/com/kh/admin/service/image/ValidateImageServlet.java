package com.kh.admin.service.image;

import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 所在的包名: com.kh.admin.service.image
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:    进行验证码图片验证的Servlet
 * @Date: Created in 21:26 2017/10/26
 */
@Service
public class ValidateImageServlet extends HttpServlet {

    /**
     * 1 获取页面的验证码
     * 2 获取session中保存的验证码
     * 3 比较验证码
     * 4 返回校验结果
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String picString = (String) request.getSession().getAttribute("piccode");
        String checkCode = request.getParameter("verifyCode");
        PrintWriter out = response.getWriter();
        if (picString.toUpperCase().equals(checkCode.toUpperCase())) {
            out.println("验证码正确");
        } else {
            out.print("验证码错误！");
        }

        out.flush();
        out.close();
    }
}
