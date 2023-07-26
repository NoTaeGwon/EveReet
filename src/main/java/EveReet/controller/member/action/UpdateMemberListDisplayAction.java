package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.*;

public class UpdateMemberListDisplayAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String currentPageNo = request.getParameter("currentPageNo");
		int cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
		
		HttpSession session = request.getSession();
		MemberPageInfoVO bpiVO = (MemberPageInfoVO)session.getAttribute("memberPageInfoVO");
		
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> memberList;
		
		bpiVO.setCurrentPageNo(cpn);
		bpiVO.adjPageInfo();

		memberList = memberDAO.getMemberListForPage(bpiVO);
		request.setAttribute("memberList", memberList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/member/member_u.jsp");
		
		return forward;
	}
}