package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.*;

public class InsertMemberAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO member = new MemberDTO();
		ActionForward forward = new ActionForward();
		
		String addr = request.getParameter("addr1") + " " +request.getParameter("addr2");
		
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setZip_code(request.getParameter("zip_code"));
		member.setAddress(addr);
		member.setPhone(request.getParameter("phone"));
		

		boolean result = memberDAO.insertMember(member);
		
		forward.setRedirect(false);
		if(result == true) {
			forward.setPath("/index.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team4/view/etc/error.jsp");
		}
		return forward;

	}



}
