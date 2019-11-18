package net.plang.DYAccount.base.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.plang.DYAccount.base.exception.DeptCodeNotFoundException;
import net.plang.DYAccount.base.exception.IdNotFoundException;
import net.plang.DYAccount.base.exception.PwMissmatchException;
import net.plang.DYAccount.base.serviceFacade.BaseServiceFacade;
import net.plang.DYAccount.hr.to.EmployeeBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLoginController extends AbstractController {
	private BaseServiceFacade baseServiceFacade;
	private ModelAndView modelAndView;

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		ModelMap modelmap = new ModelMap();
		HttpSession session = request.getSession();
		String empCode = request.getParameter("empCode");
		String userPw = request.getParameter("userPw");
		String viewname = null;
		EmployeeBean employeeBean;
		try {
			employeeBean = baseServiceFacade.getLoginData(empCode, userPw);

			session.setAttribute("empCode", employeeBean.getEmpCode());
			session.setAttribute("empName", employeeBean.getEmpName());
			session.setAttribute("deptCode", employeeBean.getDeptCode());
			session.setAttribute("deptName", employeeBean.getDeptName());
			session.setAttribute("positionName", employeeBean.getPositionName());
			viewname = "redirect://hello.html";
			modelmap.put("errorCode", 0);
			modelmap.put("errorMsg", "로그인 성공");
		} catch (IdNotFoundException e) {
			modelmap.put("errorCode", -1);
			modelmap.put("errorMsg", "존재하지 않는 아이디입니다.");
		} catch (PwMissmatchException e) {
			modelmap.put("errorCode", -2);
			modelmap.put("errorMsg", "비밀번호가 틀렸습니다.");
		} catch (DeptCodeNotFoundException e) {
			modelmap.put("errorCode", -3);
			modelmap.put("errorMsg", "예상치 못한 오류가 발생했습니다.");
		}
		modelAndView = new ModelAndView(viewname,modelmap);
		return modelAndView;
	}

	public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}
}
