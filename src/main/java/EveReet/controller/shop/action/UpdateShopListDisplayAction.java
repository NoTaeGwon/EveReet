package EveReet.controller.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.*;

public class UpdateShopListDisplayAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String currentPageNo = request.getParameter("currentPageNo");
		int cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
		
		HttpSession session = request.getSession();
		ShopPageInfoVO bpiVO = (ShopPageInfoVO)session.getAttribute("shopPageInfoVO");
		
		ShopDAO shopDAO = new ShopDAO();
		ArrayList<ShopDTO> shopList;
		
		bpiVO.setCurrentPageNo(cpn);
		bpiVO.adjPageInfo();

		shopList = shopDAO.getShopListForPage(bpiVO);
		request.setAttribute("shopList", shopList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/shop/shop_u.jsp");
		
		return forward;
	}
}