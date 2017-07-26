package com;

import java.io.IOException;

import javax.jdo.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JDO_EXServlet extends HttpServlet {
	String empName,empId,empSalary;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/HTML");
		
		empId = req.getParameter("eid");
		empName = req.getParameter("ename");
		empSalary = req.getParameter("salary");
		
		System.out.println(empId);
		System.out.println(empName);
		System.out.println(empSalary);
		
        Jdo_ex jd = new Jdo_ex();
        jd.setEmpId(empId);
        jd.setEmpName(empName);
        jd.setEmpSalary(empSalary);
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional");
        PersistenceManager pm = pmf.getPersistenceManager();
        try
        {
        	pm.makePersistent(jd);
        }catch(Exception e){
        	
        }
		
	}
}
