package net.plang.DYAccount.base.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.plang.DYAccount.base.to.OpenApiBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.sf.json.JSONObject;

public class OpenApiController extends AbstractController {
	
    protected final Log logger = LogFactory.getLog(this.getClass());
    
	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;

		return nValue.getNodeValue();
	}
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("jsonView");
		
		ArrayList<OpenApiBean> array= new ArrayList<>(); 
		OpenApiBean openApiBean = null;
		 
		
		try {
			openApiBean = new OpenApiBean();
			String url = "http://apis.data.go.kr/1480523/Airemiss/getAiremissList?numOfRows=1&pageNo=1&serviceKey=myPzPUQNnH793f%2FXjs1oNN2Oq9R6HbaBO%2Bve0nI5e%2BZfK1%2FkErdYOyF7GDgbdX2p9OyTWT9E5a9V4gWXAem9Tw%3D%3D&resultType=xml";

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(url);

			// root tag
			doc.getDocumentElement().normalize();
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName()); 최상위노드 = RESPONSE

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("item");
			Element eElement = (Element) nList.item(0);
			
			openApiBean.setSidonm(getTagValue("sidonm", eElement));
			openApiBean.setCo(getTagValue("co", eElement));
			openApiBean.setNo(getTagValue("no", eElement));
			openApiBean.setSo(getTagValue("so", eElement));
			openApiBean.setTsp(getTagValue("tsp", eElement));
			openApiBean.setPm(getTagValue("pm", eElement));
			openApiBean.setVoc(getTagValue("voc", eElement));
			openApiBean.setPm2(getTagValue("pm2", eElement));
			openApiBean.setNh3(getTagValue("nh3", eElement));
	
			array.add(openApiBean);
			
			
			modelAndView.addObject("OpenAPI", array);
			modelAndView.addObject("errorCode", 0);
            modelAndView.addObject("errorMsg", "openApi data success");
		} catch (Exception e) {
			modelAndView.addObject("errorCode", -1);
            modelAndView.addObject("errorMsg", "openApi error");
		}

		return modelAndView;
	}
}
