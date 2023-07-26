package EveReet.controller.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.ShopDAO;
import EveReet.model.shop.ShopDTO;

public class GetDetailProductInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ShopDAO shopDAO = new ShopDAO();
		ActionForward forward = new ActionForward();
		ShopDTO shopDTO = new ShopDTO();
		
		shopDTO.setProdnum(Integer.parseInt(request.getParameter("prodnum")));
		
		shopDTO = shopDAO.getProdnumDetail(shopDTO);
		
		request.setAttribute("shopDTO", shopDTO);
		
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/shop/shop_detail_product.jsp");
		
		return forward;
	}

}
