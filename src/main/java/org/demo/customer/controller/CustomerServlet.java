package org.demo.customer.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.demo.customer.model.Customer;
import org.demo.customer.service.CustomerService;

/**
 * 进入 客户列表 界面
 * Servlet是java  web项目的核心，所有服务端应用是基于Servlet或Servlet的高级形式实现的
 * web容器，例如：tomcat会把网络请求获取到，再调用对应的Servlet完成一系类工作，其中，用户应用会实现HTTPServlet接口，在容器控制业务流程中加入应用业务
 * @Controller是WebServlet的高级形式，更关注业务，而封装底层，可以在标签@Controller中直接写业务
 * @WebServlet标签标注的类必须继承HttpServlet类，并重写对应的方法
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
