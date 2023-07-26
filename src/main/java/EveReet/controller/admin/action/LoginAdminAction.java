package EveReet.controller.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EveReet.controller.admin.Action;
import EveReet.controller.admin.ActionForward;
import EveReet.model.admin.AdminDAO;
import EveReet.model.admin.AdminDTO;

public class LoginAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		AdminDAO adminDAO = new AdminDAO();
		HttpSession session = request.getSession();
		AdminDTO admin = new AdminDTO();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		admin.setId(id);
		admin.setPwd(pwd);
		
		admin = adminDAO.login(admin);
		
		if (admin.getName() == null) {
			request.setAttribute("alert", "로그인에 실패했습니다.");
			forward.setRedirect(false);
			forward.setPath("/com/yju/2wda/team4/view/admin/login.jsp");
		} else {
			session.setAttribute("adminInfo", admin);
			forward.setRedirect(false);
			forward.setPath("/com/yju/2wda/team4/view/admin/index.jsp");
		}
			
		return forward;
	}

}
