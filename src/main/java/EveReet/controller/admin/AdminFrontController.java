package EveReet.controller.admin;

import EveReet.controller.admin.action.*;
import EveReet.model.admin.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class AdminFrontController extends HttpServlet implements Servlet{
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		command = command.substring(command.lastIndexOf("/"));
		
		AdminPageInfoVO bpiVO;
		HttpSession session = request.getSession();
		
		if (session.getAttribute("adminPageInfoVO") == null) {
			bpiVO = new AdminPageInfoVO();
			session.setAttribute("adminPageInfoVO", bpiVO);
		} else {
			bpiVO = (AdminPageInfoVO)session.getAttribute("adminPageInfoVO");
		}
		
		ActionForward forward = null;
		Action action = null;
		
		System.out.println("command = " + command );
		
		switch( command ) {
		case "/loginAdmin.ad":
			action = new LoginAdminAction();
			break;
		case "/logoutAdmin.ad":
			action = new LogoutAdminAction();
			break;
		default:
			action = new DefaultAction();
			break;			
		}
		try {
			forward = action.execute(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}		


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
