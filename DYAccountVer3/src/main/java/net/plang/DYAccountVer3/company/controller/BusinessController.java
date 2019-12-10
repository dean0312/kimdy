package net.plang.DYAccountVer3.company.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import net.plang.DYAccountVer3.company.serviceFacade.BusinessServiceFacade;
import net.plang.DYAccountVer3.company.to.BusinessBean;
import net.plang.DYAccountVer3.company.to.DetailBusinessBean;

@RestController
public class BusinessController {
	@Autowired
	private BusinessServiceFacade businessServiceFacade;
	
	

	// 업태리스트조회
	@RequestMapping(value="company/BusinessList",method = RequestMethod.GET)
	public ArrayList<BusinessBean> getBusinessList() {

		return businessServiceFacade.getBusinessList();
		

	}
	
	// 자식 업태 조회
	@RequestMapping(value="company/DetailBusiness",method = RequestMethod.GET)
	public ArrayList<DetailBusinessBean> getDetailBusiness(@RequestParam String businessCode) {

			return businessServiceFacade.getDetailBusiness(businessCode);
	}

}
