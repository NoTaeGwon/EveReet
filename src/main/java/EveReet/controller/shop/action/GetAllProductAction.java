package EveReet.controller.shop.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.ShopDAO;
import EveReet.model.shop.ShopDTO;

public class GetAllProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ShopDAO shopDAO = new ShopDAO();
		ActionForward forward = new ActionForward();
		
		ArrayList<ShopDTO> allproductlist = new ArrayList<ShopDTO>();
		
		allproductlist = shopDAO.getAllShopList();
		
		request.setAttribute("allproductlist", allproductlist);
		
		forward.setRedirect(false);
		forward.setPath("/com/yju/2wda/team4/view/shop/shop_products.jsp");
		
		return forward;
	}

}
