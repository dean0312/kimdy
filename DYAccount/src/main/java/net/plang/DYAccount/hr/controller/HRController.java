package net.plang.DYAccount.hr.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.plang.DYAccount.hr.serviceFacade.HRServiceFacade;
import net.plang.DYAccount.hr.to.EmployeeBean;
import net.sf.json.JSONObject;

public class HRController extends MultiActionController {
	private static HRServiceFacade hrServiceFacade;

	public void setHrServiceFacade(HRServiceFacade hrServiceFacade) {
		this.hrServiceFacade = hrServiceFacade;
	}

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

	public ModelAndView findEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");

		String empCode = request.getParameter("empCode");
		EmployeeBean employeeBean = hrServiceFacade.findEmployee(empCode);

		modelAndView.addObject("employeeInfo", employeeBean);
		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}

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

	public ModelAndView EmptyEmpBean(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");

		modelAndView.addObject("EmptyEmpBean", new EmployeeBean());
		modelAndView.addObject("errorCode", 1);
		modelAndView.addObject("errorMsg", "성공");

		return modelAndView;
	}

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
