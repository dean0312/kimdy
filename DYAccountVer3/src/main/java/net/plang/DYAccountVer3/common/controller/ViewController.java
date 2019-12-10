
package net.plang.DYAccountVer3.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
	@RequestMapping("/{viewName}.html")
	public String view(@PathVariable String viewName) {
		System.out.println("11111");
		return "/" + viewName;
	}

	@RequestMapping("/{pack}/{viewName}.html")
	public String packView(@PathVariable String pack, @PathVariable String viewName) {
		System.out.println("111112222");
		return "/" + pack + "/" + viewName;
	}

}
