package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.*;

public class GetMemberListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> memberList;
		
		memberList = memberDAO.getMemberList();
		request.setAttribute("memberList", memberList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/member/member_r.jsp");
		
		return forward;
	}
}
