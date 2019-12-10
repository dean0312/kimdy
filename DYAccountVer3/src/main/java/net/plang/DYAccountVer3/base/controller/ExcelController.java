/*
 * package net.plang.DYAccountVer3.base.controller;
 * 
 * import java.util.HashMap; import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import net.plang.DYAccountVer3.base.serviceFacade.BaseServiceFacade; import
 * net.plang.DYAccountVer3.base.to.SlipExcelBean;
 * 
 * @Controller public class ExcelController {
 * 
 * @Autowired private BaseServiceFacade baseServiceFacade;
 * 
 * private ModelAndView modelAndView; private HashMap<String,Object>
 * modelobject;
 * 
 * @RequestMapping("base/slipExcel.do") public ModelAndView
 * slipExcel(HttpServletRequest request, HttpServletResponse response) { //
 * SMTPAppender log4j modelobject=new HashMap<>(); String from =
 * request.getParameter("from"); String to = request.getParameter("to"); String
 * viewname="null"; try { List<SlipExcelBean> slipExcel =
 * baseServiceFacade.getSlipExcelData(from, to);
 * 
 * System.out.println("@@@@@@@@@@@@@try절안");
 * modelobject.put("title","slipExcel"); modelobject.put("list",slipExcel);
 * modelobject.put("errorCode", 0); modelobject.put("errorMsg", "성공");
 * viewname="excelView";
 * 
 * } catch (Exception e) { System.out.println("@@@@@@@폭탄명"+e.getMessage());
 * modelobject.clear(); modelobject.put("errorCode", -1);
 * modelobject.put("errorMsg", "다운로드 오류입니다.");
 * System.out.println("@@@@@@@@@@catch절안"); viewname="jsonView"; throw e; }
 * modelAndView=new ModelAndView(viewname,modelobject); return modelAndView; }
 * 
 * 
 * }
 */