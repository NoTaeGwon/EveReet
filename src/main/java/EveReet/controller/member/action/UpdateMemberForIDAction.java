package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.*;

public class UpdateMemberForIDAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberDTO member = new MemberDTO();
		
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setZip_code(request.getParameter("zip_code"));
		member.setAddress(request.getParameter("address"));
		member.setPhone(request.getParameter("phone"));
		member.setUseyn(Integer.parseInt(request.getParameter("useyn")));

		MemberDAO memberDAO = new MemberDAO();
		
		boolean result = memberDAO.updateMember(member);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		if(result == true) {
			forward.setPath("/index.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team4/view/etc/error.jsp");
		}
		return forward;
	}
}