package EveReet.controller.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EveReet.controller.admin.Action;
import EveReet.controller.admin.ActionForward;

public class LogoutAdminAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		session.setAttribute("amdinInfo", null);
		
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/admin/login.jsp");
		
		return forward;
	}

}
