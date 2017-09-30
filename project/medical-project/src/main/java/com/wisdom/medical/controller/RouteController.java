package com.wisdom.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "medical/")
public class RouteController {

	/*
	elder 项目
    */
	@RequestMapping(value ="native",method = {RequestMethod.POST, RequestMethod.GET})
	public String elderNative(HttpServletResponse response) {
		response.addHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Expires","0");
		return "native/elderFirstPage";
	}

	/*
        elder ionic框架
    */
	@RequestMapping(value ="ionic",method = {RequestMethod.POST, RequestMethod.GET})
	public String elderIonic(HttpServletResponse response) {
		response.addHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Expires","0");
		return "angular/elderIonicIndex";
	}

	/*
	  elder ionic框架
	*/
	@RequestMapping(value ="surveyLogin",method = {RequestMethod.POST, RequestMethod.GET})
	public String surveyLogin(HttpServletResponse response) {
		response.addHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Expires","0");
		return "native/surveyLogin";
	}

}