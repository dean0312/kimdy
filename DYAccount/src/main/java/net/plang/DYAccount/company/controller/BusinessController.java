package net.plang.DYAccount.company.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import net.plang.DYAccount.company.serviceFacade.BusinessServiceFacade;
import net.plang.DYAccount.company.to.BusinessBean;
import net.plang.DYAccount.company.to.DetailBusinessBean;


public class BusinessController extends MultiActionController {

	private BusinessServiceFacade businessServiceFacade;
	
	public void setBusinessServiceFacade(BusinessServiceFacade businessServiceFacade) {
		this.businessServiceFacade = businessServiceFacade;
	}

	// 업태리스트조회
	public ModelAndView getBusinessList(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("jsonView");
		ArrayList<BusinessBean> businessList = businessServiceFacade.getBusinessList();
		
			modelAndView.addObject("businessList",businessList);
		return modelAndView;

	}
	
	// 자식 업태 조회
	public ModelAndView getDetailBusiness(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
			String businessCode=request.getParameter("businessCode");
			ArrayList<DetailBusinessBean> detailBusinessList = new ArrayList<>();

			detailBusinessList = businessServiceFacade.getDetailBusiness(businessCode);

			modelAndView.addObject("detailBusinessList",detailBusinessList);
			modelAndView.addObject("errorCode", 0);
		return modelAndView;

	}

}
