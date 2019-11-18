package net.plang.DYAccount.base.controller;


import java.util.ArrayList;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import net.plang.DYAccount.base.serviceFacade.BaseServiceFacade;
import net.plang.DYAccount.base.to.SlipIreportBean;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class ReportController extends MultiActionController {
	
	private BaseServiceFacade baseServiceFacade ;


    protected final Log logger = LogFactory.getLog(this.getClass());
    private ModelAndView modelAndView;
	private ModelMap modelMap = new ModelMap();

    public ModelAndView slipDetailIreport(HttpServletRequest request, HttpServletResponse response) {
    	//SMTPAppender log4j
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("utf-8");

            String slipNo = request.getParameter("slipNo");

            ArrayList<SlipIreportBean> slipDetailIreport= baseServiceFacade.getSlipIreportData(slipNo);
            for(SlipIreportBean ireport:slipDetailIreport) {
            	System.out.println(ireport.getAccount_name()+"@@동영:받아온 accountname");
            }
			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(slipDetailIreport);			
			
			modelMap.put("source", source);
			modelMap.put("format", "pdf");
			
			modelAndView = new ModelAndView("slipDetailIreportPdfView", modelMap);
//	1차작업과틀리게  Connection객체를 컨트롤러에서 ireport에 보내서 ireport xml 안에서 쿼리를 날리지않고  
//	미리 dao 까지가서 report에 필요한 데이터들을 미리 들고온뒤 jrbeancollectiondatasource를이용해 JasperReportsMultiFormatView 를사용하여 같이날려주면
//	ireport에 bean 만 맞춰주면 자동으로 필드값세팅이되어 ireport 에서 쿼리를 날릴필요가없어짐.
        return modelAndView;
    }
    public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
        this.baseServiceFacade = baseServiceFacade;
    }
}

