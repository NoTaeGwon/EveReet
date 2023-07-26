package EveReet.controller.shop.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.eclipse.jdt.internal.compiler.env.IGenericField;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.ShopDAO;
import EveReet.model.shop.ShopDTO;

public class AddToCartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
//		ShopDAO shopDAO = new ShopDAO();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		int prodnum = Integer.parseInt(request.getParameter("prodnum"));
		
		ArrayList<ShopDTO> cartList;
		
		if (session.getAttribute("cartList") == null) {
			cartList = new ArrayList<ShopDTO>();
		} else {
			cartList = (ArrayList<ShopDTO>)session.getAttribute("cartList");
		}
		
		boolean checker = false;
		
		for (ShopDTO shopDTO : cartList) {
			if (shopDTO.getProdnum() == prodnum) { // 리스트 안에 이미 물건이 있을 떄 - 물건에 수량 증가 시키기
				shopDTO.addQuantity();
				checker = true;
			}
		}
		
		if (checker == false) {
		// 리스트 안에 이미 물건이 없을 때 - 리스트에 물건 추가하기
			ShopDTO tempDto = new ShopDAO().getShop(prodnum);
			tempDto.addQuantity();
			cartList.add(tempDto);
		}
		
		
		session.setAttribute("cartList", cartList);
		
		for (ShopDTO x : cartList) {
			System.out.println(x + "<--- shopDTO CartList");
		}
		
		forward.setRedirect(false);
		forward.setPath("./getAllProduct.sh"); 
		
		return forward;
	}

}
