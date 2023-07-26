package EveReet.controller.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.admin.Action;
import EveReet.controller.admin.ActionForward;
import EveReet.model.admin.*;

public class DefaultAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/etc/error/jsp");
		return forward;
	}

}
