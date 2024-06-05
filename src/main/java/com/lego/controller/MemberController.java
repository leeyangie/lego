package com.lego.controller;




import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lego.dto.Member;
import com.lego.mapper.MemberMapper;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberMapper memberService;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private HttpSession session;	
	
	
	@GetMapping("login.do")
	public String login(Model model) {
		return "member/login";
	}
	
	@PostMapping("loginPro.do")
	public String loginPro(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model, RedirectAttributes rttr, HttpSession session) {
	    Member cus = memberService.getMember(id);
	    if (cus != null) {
	        boolean loginSuccess;
	        if (id.equals("admin")) {
	            // 아이디가 "admin"인 경우 평문 비밀번호 비교
	            loginSuccess = pw.equals(cus.getPw());
	        } else {
	            // 일반 사용자는 해시된 비밀번호와 비교
	            loginSuccess = pwdEncoder.matches(pw, cus.getPw());
	        }

	        if (loginSuccess) {
	            session.setAttribute("cus", cus);
	            session.setAttribute("sid", id);
	            model.addAttribute("msg", "로그인 성공");
	            return "redirect:/";
	        } else {
	            rttr.addFlashAttribute("msg", "로그인 실패");
	            return "redirect:login.do";
	        }
	    } else {
	        rttr.addFlashAttribute("msg", "사용자가 존재하지 않습니다.");
	        return "redirect:login.do";
	    }
	}
	
	@GetMapping("agree.do")
	public String agree(Model model, RedirectAttributes rttr) {
		rttr.addAttribute("msg", "회원 약관에 동의하시기 바랍니다.");
		return "member/agree";
	}
	
	@GetMapping("join.do")
	public String join(Model model, @ModelAttribute("member") Member member) {
		model.addAttribute("member", member);
		return "member/join";
	}
	
	@PostMapping("idCheck.do")
	@ResponseBody
	public Map<String, Boolean> idCheck(@RequestParam("id") String id) {
	    Map<String, Boolean> resultMap = new HashMap<>();
	    Member cus = memberService.getMember(id);
	    boolean result = cus == null; // 회원이 존재하지 않으면 true, 존재하면 false
	    resultMap.put("result", result);
	    return resultMap;
	}
	
	@PostMapping("joinPro.do")
	public String joinPro(HttpServletRequest request, Model model, RedirectAttributes rttr) {
	    String id = request.getParameter("id");
	    System.out.println("ID: " + id); // id를 콘솔에 출력

	    Member member = new Member();
	    member.setId(id);
	    member.setPw(pwdEncoder.encode(request.getParameter("pw")));    // 비밀번호 암호화
	    member.setName(request.getParameter("name"));
	    member.setEmail(request.getParameter("email"));
	    member.setTel(request.getParameter("tel"));
	    member.setAddress1(request.getParameter("address1"));
	    member.setAddress2(request.getParameter("address2"));
	    member.setPostcode(request.getParameter("postcode"));
	    memberService.insMember(member);
	    model.addAttribute("msg", "회원가입을 축하합니다.");
	    return "redirect:/";
	}
	
	
	@GetMapping("logout.do")
	public String logout(Model model, RedirectAttributes rttr) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃 하였습니다.");
		return "redirect:/";
	}
	
	@GetMapping("mypage.do")
	public String myInfo(Model model) {
		return "member/mypage";
	}
	
	@GetMapping("myUpdate.do")
	public String myUpdate(Model model) {
		return "member/myUpdate";
	}
	
	
	@PostMapping("myUpdatePro.do")
	public String myUpdatePro(HttpServletRequest request, Model model, RedirectAttributes rttr) {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(pwdEncoder.encode(request.getParameter("pw")));	//비밀번호 암호화
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setTel(request.getParameter("tel"));
		member.setAddress1(request.getParameter("addr1"));
		member.setAddress2(request.getParameter("addr2"));
		member.setPostcode(request.getParameter("postcode"));
		memberService.changeInfo(member);
		model.addAttribute("msg", "회원가입을 축하합니다.");
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("memberDelete.do")
	public String memberDelete(@RequestParam("id") String id, Model model) {
		memberService.delMember(id);
		session.invalidate();
		return "redirect:/";
	}
}
