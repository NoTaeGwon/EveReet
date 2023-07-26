package EveReet.controller.member;

import EveReet.controller.member.*;
import EveReet.controller.member.action.*;
import EveReet.model.member.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;

public class MemberFrontController extends HttpServlet implements Servlet{
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		command = command.substring(command.lastIndexOf("/"));
		
		MemberPageInfoVO bpiVO;
		HttpSession session = request.getSession();
		
		if (session.getAttribute("memberPageInfoVO") == null) {
			bpiVO = new MemberPageInfoVO();
			session.setAttribute("memberPageInfoVO", bpiVO);
		} else {
			bpiVO = (MemberPageInfoVO)session.getAttribute("memberPageInfoVO");
		}
		
		ActionForward forward = null;
		Action action = null;
		
		System.out.println("command = " + command );
		
		switch( command ) {
		case "/loginMember.me":
			action = new LoginMemberAction();
			break;
		case "/logoutMember.me":
			action = new LogoutMemberAction();
			break;
		case "/insertMember.me":
			action = new InsertMemberAction();
			break;
		case "/getMemberList.me":
			action = new GetMemberListAction();
			break;
		case "/getMemberListForPage.me":
			action = new GetMemberListForPageAction();
			break;
		case "/adjustBPI.me":
			action = new AdjustBPIAction();
			break;
		case "/deleteMemberForID.me":
			action = new DeleteMemberForIDAction();
			break;
		case "/deleteMemberListDisplay.me":
			action = new DeleteMemberListDisplayAction();
			break;	
		case "/updateMemberListDisplay.me":
			action = new UpdateMemberListDisplayAction();
			break;
		case "/updateMemberDisplay.me":
			action = new UpdateMemberDisplayAction();
			break;
		case "/updateMemberForID.me":
			action = new UpdateMemberForIDAction();
			break;
		default:
			action = new DefaultAction();
			break;			
		}
		try {
			forward = action.execute(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}		
		
//		beerDAO = new BeerDAO();
//		boolean result;
//		String displayRecordCnt;
//		int drc;
//		String currentPageNo;
//		int cpn;
//		
//		switch(actionType) {
//		case "C": // 기본데이터 입력 C-모듈
//			beer = new BeerDTO();
//			
//			beer.setB_code(request.getParameter("b_code"));
//			beer.setB_category(request.getParameter("b_category"));
//			beer.setB_name(request.getParameter("b_name"));
//			beer.setB_country(request.getParameter("b_country"));
//			beer.setB_price(Integer.parseInt(request.getParameter("b_price")));
//			beer.setB_alcohol(request.getParameter("b_alcohol"));
//			beer.setB_content(request.getParameter("b_content"));
//			beer.setB_like(0);
//			beer.setB_dislike(0);
//			beer.setB_image("baseImage.jsp");
//
//			result = beerDAO.insertBeer(beer);
//
//			if (result == true) {
//				request.getRequestDispatcher("/index.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("/com/yju/2wda/team4/view/etc/error.jsp").forward(request, response);
//			}
//			break;
//			
//		case "C_code": // b_code 생성
//			BeerDTO c_category = null; // 맥주종류 코드를 반환 받을 DTO
//			BeerDTO c_country = null; // 국가 코드를 반환 받을 DTO
//			String c_last = "";
//			beer = new BeerDTO(); // insert에 담을 DTO
//			
//			beerDAO = new BeerDAO();
//	
//			// 국가번호 종류 일련번호
//			c_category = beerDAO.getCode_categorycode(request.getParameter("b_category"));
//			c_country = beerDAO.getCode_countrycode(request.getParameter("b_country"));
//			
//			System.out.println(beer.getCode_categorycode());
//			String code_category = c_category.getCode_categorycode(); // DTO에 담을 category 변수
//			String code_country = c_country.getCode_countrycode(); // DTO에 담을 country 변수
//			
//			c_last = beerDAO.getCode_lastName(code_category, code_country);
//			
//			System.out.println(code_category + "<-- code_category");
//			System.out.println(code_country + "<-- code_country");
//			System.out.println(c_last + "<-- c_last");
//			
//			String B_code = "BE" + code_category + code_country + c_last; // code 조합 변수 
//			
//			System.out.println(B_code + "<-- B_code 조합");
//			
//			beer.setB_code(c_last);
//			beer.setB_category(request.getParameter("b_category"));
//			beer.setB_name(request.getParameter("b_name"));
//			beer.setB_country(request.getParameter("b_country"));
//			beer.setB_price(Integer.parseInt(request.getParameter("b_price")));
//			beer.setB_alcohol(request.getParameter("b_alcohol"));
//			beer.setB_content(request.getParameter("b_content"));
//			beer.setB_like(0);
//			beer.setB_dislike(0);
//			beer.setB_image("baseImage.jsp");
//
//			result = beerDAO.insertBeer(beer);
//
//			if (result == true) {
//				request.getRequestDispatcher("/index.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("/com/yju/2wda/team4/view/etc/error.jsp").forward(request, response);
//			}
//			
//			break;
//			
//
//		case "R": // 페이징 기능 없는 R-모듈
//
//			beerList = beerDAO.getBeerList();
//
//			request.setAttribute("beerList", beerList);
//			request.getRequestDispatcher("/com/yju/2wda/team4/view/beer/beer_r.jsp").forward(request, response);
//
//			break;
//
//		case "R4": // 페이지 기능 포함 R-모듈
//		
//			currentPageNo = request.getParameter("currentPageNo");
//			cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
//
//			bpiVO.setCurrentPageNo(cpn);
//			bpiVO.adjPageInfo();
//
//			beerList = beerDAO.getBeerListForPage(bpiVO);
//
//			request.setAttribute("beerList", beerList);
//			request.getRequestDispatcher("/com/yju/2wda/team4/view/beer/beer_r4.jsp").forward(request, response);
//
//			break;
//
//		case "R_DRC": // 페이지당 디스플레이 레코드 갯수 변경 처리
//		
//			displayRecordCnt = request.getParameter("displayRecordCnt");
//			drc = (displayRecordCnt == null) ? 10 : Integer.parseInt(displayRecordCnt);
//
//			bpiVO.setLimitCnt(drc);
//			bpiVO.setCurrentPageNo(0);
//			bpiVO.adjPageInfo();
//
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//
//			break;
//			
//	      case "R4S":
//	          currentPageNo = request.getParameter("currentPageNo");
//	          
//	          String kind = request.getParameter("kind");
//	          
//	          cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
//	          
//	          bpiVO.setCurrentPageNo(cpn);
//	          bpiVO.adjPageInfo();
//	          
//	          beerList = beerDAO.getBeerListForOption(bpiVO, kind);
//	          
//	          request.setAttribute("beerList", beerList);
//	          request.getRequestDispatcher("/com/yju/2wda/team4/view/beer/beer_r4s.jsp?kind="+kind).forward(request, response);
//	          break;
//
//		case "D_ID": // 조건에 해당하는 레코드 삭제 처리
//
//			int b_id = Integer.parseInt(request.getParameter("b_id"));
//
//			result = beerDAO.deleteBeer(b_id);
//
//			if (result == true) {
//				request.getRequestDispatcher("/com/yju/2wda/team4/BeerController.be?actionType=D").forward(request, response);
//			} else {
//				request.getRequestDispatcher("/com/yju/2wda/team4/view/etc/error.jsp").forward(request, response);
//			}
//			break;
//
//		case "D": // 페이지당 디스플레이 레코드 갯수 출력 및 삭제 처리
//		
//			currentPageNo = request.getParameter("currentPageNo");
//			cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
//
//			bpiVO.setCurrentPageNo(cpn);
//			bpiVO.adjPageInfo();
//
//			beerList = beerDAO.getBeerListForPage(bpiVO);
//
//			request.setAttribute("beerList", beerList);
//			request.getRequestDispatcher("/com/yju/2wda/team4/view/beer/beer_d.jsp").forward(request, response);
//
//			break;
//
//		case "U": // 페이지당 디스플레이 레코드 갯수 출력 및 수정 처리
//		
//			currentPageNo = request.getParameter("currentPageNo");
//			cpn = (currentPageNo == null) ? 0 : Integer.parseInt(currentPageNo);
//
//			bpiVO.setCurrentPageNo(cpn);
//			bpiVO.adjPageInfo();
//
//			beerList = beerDAO.getBeerListForPage(bpiVO);
//
//			request.setAttribute("beerList", beerList);
//			request.getRequestDispatcher("/com/yju/2wda/team4/view/beer/beer_u.jsp").forward(request, response);
//
//			break;
//
//		case "U2": // b_id 값에 해당하는 DB레코드 정보 가져오기
//		
//			b_id = Integer.parseInt(request.getParameter("b_id"));
//			beer = beerDAO.getBeer(b_id);
//
//			request.setAttribute("beer", beer);
//			request.getRequestDispatcher("/com/yju/2wda/team4/view/beer/beer_u2.jsp").forward(request, response);
//
//			break;
//
//		case "U_ID": // b_id에 해당하는 DB레코드 정보 수정하기
//		
//			beer = new BeerDTO();
//
//			beer.setB_id(Integer.parseInt(request.getParameter("b_id")));
//			beer.setB_code(request.getParameter("b_code"));
//			beer.setB_category(request.getParameter("b_category"));
//			beer.setB_name(request.getParameter("b_name"));
//			beer.setB_country(request.getParameter("b_country"));
//			beer.setB_price(Integer.parseInt(request.getParameter("b_price")));
//			beer.setB_alcohol(request.getParameter("b_alcohol"));
//			beer.setB_content(request.getParameter("b_content"));
//			beer.setB_like(Integer.parseInt(request.getParameter("b_like")));
//			beer.setB_dislike(Integer.parseInt(request.getParameter("b_dislike")));
//			beer.setB_image(request.getParameter("b_image"));
//
//			result = beerDAO.updateBeer(beer);
//
//			if (result == true) {
//				request.getRequestDispatcher("/index.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("/com/yju/2wda/team4/view/etc/error.jsp").forward(request, response);
//			}
//			break;
//
//		
//		
//		}
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
