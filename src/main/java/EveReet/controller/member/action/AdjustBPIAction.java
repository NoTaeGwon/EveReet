package EveReet.controller.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.member.Action;
import EveReet.controller.member.ActionForward;
import EveReet.model.member.*;

public class AdjustBPIAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String displayRecordCnt = request.getParameter("displayRecordCnt");
		int drc = (displayRecordCnt == null) ? 10 : Integer.parseInt(displayRecordCnt);
		
		HttpSession session = request.getSession();
		MemberPageInfoVO bpiVO = (MemberPageInfoVO)session.getAttribute("memberPageInfoVO");
		
		bpiVO.setLimitCnt(drc);
		bpiVO.setCurrentPageNo(0);
		bpiVO.adjPageInfo();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		return forward;
	}

}
