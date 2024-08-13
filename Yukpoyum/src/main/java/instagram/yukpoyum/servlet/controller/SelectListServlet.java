package instagram.yukpoyum.servlet.controller;

import java.io.IOException;
import java.util.List;

import instagram.yukpoyum.dto.Member;
import instagram.yukpoyum.service.MemberService;
import instagram.yukpoyum.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectList")
public class SelectListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			MemberService service = new MemberServiceImpl();
			List<Member> memberList = service.getMemberList();
			
			req.setAttribute("memberList", memberList);
			
			String path = "/WEB-INF/views/selectList.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}