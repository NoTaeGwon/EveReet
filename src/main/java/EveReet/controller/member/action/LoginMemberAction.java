package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.MemberDAO;
import EveReet.model.member.MemberDTO;

public class LoginMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		MemberDAO memberDAO = new MemberDAO();
		HttpSession session = request.getSession();
		MemberDTO member = new MemberDTO();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		member.setId(id);
		member.setPwd(pwd);
		
		member = memberDAO.login(member);
		
		if (member.getName() == null) {
			request.setAttribute("alert", "로그인에 실패했습니다.");
			forward.setRedirect(false);
			forward.setPath("/com/yju/2wda/team4/view/member/login.jsp");
		} else {
			session.setAttribute("userInfo", member);
			forward.setRedirect(false);
			forward.setPath("/index.jsp");
		}
			
		return forward;
	}

}
