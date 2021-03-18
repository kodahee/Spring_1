package com.lalalala.s1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	// 메서드명 test3
	// print 아무거나
	// URL /member/memberLogin.do
	@RequestMapping(value = "/member/memberLogin.do")
	public void test3() {
		System.out.println("*******Test3*******");
	}

}
