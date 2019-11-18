package net.plang.DYAccount.company.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.plang.DYAccount.common.util.BeanCreator;
import net.plang.DYAccount.company.serviceFacade.WorkplaceServiceFacade;
import net.plang.DYAccount.company.to.WorkplaceBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WorkPlaceController extends MultiActionController {

	private WorkplaceServiceFacade workplaceServiceFacade;

	public void setWorkplaceServiceFacade(WorkplaceServiceFacade workplaceServiceFacade) {
		this.workplaceServiceFacade = workplaceServiceFacade;
	}

	// 사업장등록
	public ModelAndView workPlaceAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");

		JSONObject workplaceAddItems = JSONObject.fromObject(request.getParameter("workplaceAddItems"));
		WorkplaceBean workplaceBean = BeanCreator.getInstance().create(workplaceAddItems, WorkplaceBean.class);

		workplaceServiceFacade.workplaceAdd(workplaceBean); // insert
		modelAndView.addObject("errorCode", 0);
		modelAndView.addObject("errorMsg", "회사등록완료");
		return modelAndView;
	}

	// 회사삭제
	public ModelAndView eliminationWorkplace(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		ArrayList<String> getCodes = new ArrayList<>();
		String codes = request.getParameter("codes");
		JSONArray jsonArray = JSONArray.fromObject(codes);
		for (Object obj : jsonArray) {
			String code = (String) obj;
			getCodes.add(code);
		}
		workplaceServiceFacade.eliminationWorkplace(getCodes); // delete
		modelAndView.addObject("errorCode", 0);
		modelAndView.addObject("errorMsg", "회사삭제완료");

		return modelAndView;

	}

	// 사업장 1개 조회
	public ModelAndView getWorkplace(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		WorkplaceBean workplaceBean = new WorkplaceBean();
		WorkplaceBean emptyWorkplaceBean = new WorkplaceBean();

		String workplaceCode = request.getParameter("workplaceCode");
		workplaceBean = workplaceServiceFacade.getWorkplace(workplaceCode);

		modelAndView.addObject("workplaceBean", workplaceBean);
		modelAndView.addObject("emptyWorkplaceBean", emptyWorkplaceBean);

		return modelAndView;
	}

	// 모든사업장조회
	public ModelAndView getAllWorkplaceList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		ArrayList<WorkplaceBean> allWorkplaceList = new ArrayList<>();
		allWorkplaceList = workplaceServiceFacade.getAllWorkplaceList();

		modelAndView.addObject("allWorkplaceList", allWorkplaceList);
		modelAndView.addObject("errorCode", 0);
		return modelAndView;
	}

	// 승인상태 업뎃
	public ModelAndView updateApprovalStatus(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		ArrayList<String> getCodes = new ArrayList<>();

		String status = request.getParameter("status");
		String codes = request.getParameter("codes");
		JSONArray jsonArray = JSONArray.fromObject(codes);
		for (Object obj : jsonArray) {
			String code = (String) obj;
			getCodes.add(code);
		}
		workplaceServiceFacade.updateApprovalStatus(getCodes, status);
		modelAndView.addObject("errorCode", 0);
		modelAndView.addObject("errorMsg", "거래처변경완료");

		return modelAndView;
	}
}
