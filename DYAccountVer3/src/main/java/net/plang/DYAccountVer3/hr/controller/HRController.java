package net.plang.DYAccountVer3.hr.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import net.plang.DYAccountVer3.hr.serviceFacade.HRServiceFacade;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;
import net.sf.json.JSONObject;


@Controller
public class HRController{
	@Autowired
	private static HRServiceFacade hrServiceFacade;

	@RequestMapping("/hr/findEmployeeList.do")
	public ModelAndView findEmployeeList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		String deptCode = request.getParameter("deptCode");
		System.out.println("		@ 부서 코드 : " + deptCode);
		ArrayList<EmployeeBean> empList = hrServiceFacade.findEmployeeList(deptCode);

		modelAndView.addObject("empList", empList);
		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}
	@RequestMapping("/hr/findEmployee.do")
	public ModelAndView findEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");

		String empCode = request.getParameter("empCode");
		EmployeeBean employeeBean = hrServiceFacade.findEmployee(empCode);

		modelAndView.addObject("employeeInfo", employeeBean);
		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}
	@RequestMapping("/hr/batchEmpInfo.do")
	public ModelAndView batchEmpInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("employeeInfo"));
		String image = request.getParameter("image");
		
		EmployeeBean employeeBean = (EmployeeBean) JSONObject.toBean(jsonObject, EmployeeBean.class);
		employeeBean.setImage(image);
		hrServiceFacade.batchEmployeeInfo(employeeBean);
		System.out.println("		@ Emp: " + employeeBean.getEmpCode());

		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}
	@RequestMapping("/hr/EmptyEmpBean.do")
	public ModelAndView EmptyEmpBean(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");

		modelAndView.addObject("EmptyEmpBean", new EmployeeBean());
		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}
	@RequestMapping("/hr/batchEmp.do")
	public ModelAndView batchEmp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		
		JSONObject jsonObject = JSONObject.fromObject(request.getParameter("JoinEmployee"));
		EmployeeBean employeeBean = (EmployeeBean) JSONObject.toBean(jsonObject, EmployeeBean.class);

		hrServiceFacade.registerEmployee(employeeBean);
		System.out.println("		@ Emp: " + employeeBean.getEmpCode());
		System.out.println("		@ Emp: " + employeeBean.getImage());

		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}
	@RequestMapping("/hr/deleteEmployee.do")
	public ModelAndView deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");

		String empCode = request.getParameter("empCode");
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmpCode(empCode);

		hrServiceFacade.removeEmployee(employeeBean);
		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}
}
