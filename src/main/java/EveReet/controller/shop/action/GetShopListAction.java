package EveReet.controller.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.*;

public class GetShopListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 
		ShopDAO shopDAO = new ShopDAO();
		ArrayList<ShopDTO> shopList;
		
		shopList = shopDAO.getShopList();
		request.setAttribute("shopList", shopList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/shop/shop_r.jsp");
		
		return forward;
	}
}
