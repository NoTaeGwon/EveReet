package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.*;

public class DeleteMemberForIDAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		MemberDAO memberDAO = new MemberDAO();
		
		boolean result = memberDAO.deleteMember(id);
		
		ActionForward forward = new ActionForward();
		
		if (result == true) {
			forward.setRedirect(true);
			forward.setPath("./deleteMemberListDisplay.me");
		} else {
			forward.setRedirect(false);
			forward.setPath("/com/yju/2wda/team4/view/etc/error.jsp");
		}
		return forward;
	}
}
