package net.plang.DYAccountVer3.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.plang.DYAccountVer3.base.serviceFacade.CodeListServiceFacade;
import net.plang.DYAccountVer3.base.to.CodeBean;
import net.plang.DYAccountVer3.base.to.DetailCodeBean;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CodeListController {
	@Autowired
	private CodeListServiceFacade codeListServiceFacade;

	@RequestMapping(value = "base/DetailCodeList", method = RequestMethod.GET)
	public ArrayList<DetailCodeBean> getDetailCodeList(
			@RequestParam String divisionCodeNo,HttpServletRequest request) {
		String detailCodeName=request.getParameter("detailCodeName");
		if(detailCodeName == null) {detailCodeName="";}
		System.out.println("코드네임:"+detailCodeName);
		HashMap<String, String> param = new HashMap<>();
		System.out.println("division코드확인:"+divisionCodeNo);
		param.put("divisionCodeNo", divisionCodeNo);
		if (detailCodeName != null) {
			param.put("detailCodeName", detailCodeName);}
	

		return codeListServiceFacade.getDetailCodeList(param);

	}

	@RequestMapping(value = "base/CodeList", method = RequestMethod.GET)
	public ArrayList<CodeBean> findCodeList() {

		return codeListServiceFacade.findCodeList();

	}

}
