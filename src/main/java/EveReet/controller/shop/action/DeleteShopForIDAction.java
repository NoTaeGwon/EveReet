package EveReet.controller.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.*;

public class DeleteShopForIDAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int prodnum = Integer.parseInt(request.getParameter("prodnum"));
		
		ShopDAO shopDAO = new ShopDAO();
		
		boolean result = shopDAO.deleteShop(prodnum);
		
		ActionForward forward = new ActionForward();
		
		if (result == true) {
			forward.setRedirect(true);
			forward.setPath("./deleteShopListDisplay.sh");
		} else {
			forward.setRedirect(false);
			forward.setPath("/com/yju/2wda/team4/view/etc/error.jsp");
		}
		return forward;
	}
}
