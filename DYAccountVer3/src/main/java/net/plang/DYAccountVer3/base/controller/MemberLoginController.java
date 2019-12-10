package net.plang.DYAccountVer3.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.plang.DYAccountVer3.base.exception.DeptCodeNotFoundException;
import net.plang.DYAccountVer3.base.exception.IdNotFoundException;
import net.plang.DYAccountVer3.base.exception.PwMissmatchException;
import net.plang.DYAccountVer3.base.serviceFacade.BaseServiceFacade;
import net.plang.DYAccountVer3.hr.to.EmployeeBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@RestController
public class MemberLoginController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String empCode,@RequestParam String userPw,HttpServletRequest request) {

		ModelMap modelmap = new ModelMap();
		HttpSession session = request.getSession();
		String viewname = null;
		EmployeeBean employeeBean;
		try {
			employeeBean = baseServiceFacade.getLoginData(empCode, userPw);

			session.setAttribute("empCode", employeeBean.getEmpCode());
			session.setAttribute("empName", employeeBean.getEmpName());
			session.setAttribute("deptCode", employeeBean.getDeptCode());
			session.setAttribute("deptName", employeeBean.getDeptName());
			session.setAttribute("positionName", employeeBean.getPositionName());
			viewname = "hello";
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
		return viewname;
	}

	
}
