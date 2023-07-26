package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.MemberDAO;
import EveReet.model.member.MemberDTO;

public class LogoutMemberAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		session.setAttribute("userInfo", null);
		
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		
		return forward;
	}
}
