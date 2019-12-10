package net.plang.DYAccountVer3.common.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
public class htmlController{
	public String movepage(HttpServletRequest request, HttpServletResponse response){
		System.out.println("html컨트롤러진입");
		String uri=request.getRequestURI();
		System.out.println(uri);
		return uri;
	}
}
