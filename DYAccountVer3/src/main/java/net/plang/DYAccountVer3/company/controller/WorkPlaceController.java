package net.plang.DYAccountVer3.company.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.plang.DYAccountVer3.company.serviceFacade.WorkplaceServiceFacade;
import net.plang.DYAccountVer3.company.to.WorkplaceBean;
import net.sf.json.JSONArray;

@RestController
public class WorkPlaceController {
	@Autowired
	private WorkplaceServiceFacade workplaceServiceFacade;

	// 사업장등록
	@RequestMapping(value = "company/workPlace", method = RequestMethod.POST)
	public HashMap<String, Object> workPlaceAdd(@RequestBody WorkplaceBean workplaceAddItems) {
		HashMap<String, Object> map = new HashMap<>();

		workplaceServiceFacade.workplaceAdd(workplaceAddItems); // insert
		map.put("errorCode", 0);
		map.put("errorMsg", "회사등록완료");
		return map;
	}

	// 회사삭제
	@RequestMapping(value = "company/eliminationWorkplace", method = RequestMethod.POST)
	public void eliminationWorkplace(@RequestBody ArrayList<String> codes) {

		workplaceServiceFacade.eliminationWorkplace(codes); // delete

	}

	// 사업장 1개 조회
	@RequestMapping(value = "company/Workplace", method = RequestMethod.GET)
	public WorkplaceBean getWorkplace(@RequestParam String workplaceCode) {

		return workplaceServiceFacade.getWorkplace(workplaceCode);
	}

	// 모든사업장조회
	@RequestMapping(value = "company/AllWorkplaceList", method = RequestMethod.GET)
	public ArrayList<WorkplaceBean> getAllWorkplaceList() {

		return workplaceServiceFacade.getAllWorkplaceList();

	}

	// 승인상태 업뎃
	@RequestMapping(value = "company/ApprovalStatus", method = RequestMethod.PUT)
	public void updateApprovalStatus(@RequestParam String status, @RequestBody ArrayList<String> codes) {
	 workplaceServiceFacade.updateApprovalStatus(codes, status);
	}
}
