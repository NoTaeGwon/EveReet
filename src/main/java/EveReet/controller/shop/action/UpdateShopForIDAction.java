package EveReet.controller.shop.action;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import EveReet.controller.shop.Action;
import EveReet.controller.shop.ActionForward;
import EveReet.model.shop.*;

public class UpdateShopForIDAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
request.setCharacterEncoding("utf-8");
		
	    String imgDirPath = "D:\\Dev\\Workspace\\EveReet\\src\\main\\webapp\\com\\yju\\2wda\\team4\\images";
	    int maxSize = 1024 * 1024 * 5;

	    MultipartRequest multi = new MultipartRequest(request, imgDirPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		ShopDAO shopDAO = new ShopDAO();
		ShopDTO shop = new ShopDTO();
		Enumeration<?> files = multi.getFileNames();
		makeThumb(multi, imgDirPath);
		String element = "";
		String filesystemName = "";
		String originalFileName = "";
		String contentType = "";
		long length = 0;
		
		Vector<String> imgfile = new Vector(); 
		while (files.hasMoreElements()) {
			element = (String)files.nextElement();
			
			filesystemName 		= multi.getFilesystemName(element);
//			originalFileName 	= multi.getOriginalFileName(element);
//			contentType 		= multi.getContentType(element);
//			length 				= multi.getFile(element).length();
			if (filesystemName == null || filesystemName.equals("")) {
				continue;
			}
			imgfile.add(filesystemName);
		}
		
		shop.setProdnum(Integer.parseInt(multi.getParameter("prodnum")));
		shop.setName(multi.getParameter("name"));
		shop.setKind(multi.getParameter("kind"));
		shop.setBrand(multi.getParameter("brand"));
		shop.setPrice1(Integer.parseInt(multi.getParameter("price1")));
		shop.setPrice2(Integer.parseInt(multi.getParameter("price2")));
		shop.setContent(multi.getParameter("content"));
		// 이미지 request 고치기!
//		shop.setImage(request.getParameter("image"));
//		shop.setDetail_image(request.getParameter("detail_image"));
		shop.setImage(imgfile.get(0));
		shop.setDetail_image(imgfile.get(1));
		shop.setThumb_image("thumb_450_" + imgfile.get(0));
		shop.setUseyn("y");
		boolean result = shopDAO.updateShop(shop);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if(result == true) {
			forward.setPath("/com/yju/2wda/team4/view/admin/index.jsp");
		} else {
			forward.setPath("/com/yju/2wda/team4/view/etc/error.jsp");
		}
		return forward;

	}

	private void makeThumb (MultipartRequest multi, String imgDirPath) {
	      int maxSize = 1024 * 1024 * 10;
	      
	      Enumeration<?> files = multi.getFileNames();
	      File originalImage = null;
	      
	      String element = "";
	      String filesystemName = "";
	      String originalFileName = "";
	      String contentType = "";
	      long length = 0;
	      
	      // 원본 파일 경로
	      String path = "";
	      
	      if (files.hasMoreElements()) {
	         element = (String)files.nextElement();
	         
	         filesystemName = multi.getFilesystemName(element);
	         originalFileName = multi.getOriginalFileName(element);
	         contentType = multi.getContentType(element);
	         length = multi.getFile(element).length();
	         originalImage = multi.getFile(element);
	         path = imgDirPath + filesystemName;
	         
	         int index = path.lastIndexOf(".");
	         String ext = path.substring(index + 1); // 파일 확장자
	         
	         // 저장 경로
	         String tempPath = originalImage.getParent() + File.separator + "\\thumb\\thumb_450_" + originalImage.getName();
	         // 썸네임을 담아둘 임시 파일
	         File tempFile = new File(tempPath);
	         
	         try {
	            // 원본 이미지
	            BufferedImage image = ImageIO.read(originalImage);
	            
	            int width = 450;
	            double temp = 450.0 / image.getWidth(); // 이미지 배율
	            int height = (int)((double)image.getHeight() * temp);
	            
	            // 썸네일을 담아둘 임시 이미지
	            BufferedImage tempImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	            // 그리는 툴
	            Graphics2D g = tempImage.createGraphics();
	            // 원본 이미지 정보
	            Image img = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	            // 그리기
	            g.drawImage(img, 0, 0, width, height, null);
	            // 리소스 해제
	            g.dispose();
	            
	            // 그린 이미지 파일 형태로 출력
	            ImageIO.write(tempImage, ext, tempFile);
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         
	         
	      }
	   }
}