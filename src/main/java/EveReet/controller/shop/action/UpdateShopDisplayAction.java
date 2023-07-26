package EveReet.controller.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.*;

public class UpdateShopDisplayAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int prodnum = Integer.parseInt(request.getParameter("prodnum"));
		
		ShopDAO shopDAO = new ShopDAO();
		ShopDTO shop = new ShopDTO();
		shop = shopDAO.getShop(prodnum);

		request.setAttribute("shop", shop);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/shop/shop_u2.jsp");
		
		return forward;
	}
}