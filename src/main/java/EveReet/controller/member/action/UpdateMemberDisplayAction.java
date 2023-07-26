package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.*;

public class UpdateMemberDisplayAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO member = new MemberDTO();
		member = memberDAO.getMember(id);

		request.setAttribute("member", member);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/member/member_u2.jsp");
		
		return forward;
	}
}