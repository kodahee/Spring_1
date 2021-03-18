package com.lalalala.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// memberJoin
	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.GET)
	public String memberJoin() {
		
		return "member/memberJoin";
	}
	
	// memberJoin2
	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.POST)
	public void memberJoin2(String id, String pw, String name, String phone, String email) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		
		int result = memberService.memberJoin(memberDTO);
		
		System.out.println(result);
	}
	
	// 메서드명 memberLogin
	// 확인용 print 아무거나
	// URL /member/memberLogin
	@RequestMapping(value = "/member/memberLogin")		//jsp 파일의 위치와 url은 별개임
	public String memberLogin() {
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
		
//		System.out.println(name);
//		System.out.println(age);
		
		System.out.println("memberLogin");
		
		// WEB-INF/view/member/membrLogin.jsp
		// WEB-INF/view/ 까지 servlet-context.xml에 써 있음
		return "member/memberLogin";
	}
	
	// 메서드명 memberLogin2
	@RequestMapping(value = "/member/memberLogin", method = RequestMethod.POST)
	public void memberLogin2(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		System.out.println("Member Login 2");
//		System.out.println("ID : " + id);
//		System.out.println("PW : " + pw);
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		
		memberDTO = memberService.memberLogin(memberDTO);
		
		System.out.println(memberDTO);		// 실패시 null, 성공시 url
		
	}

}
