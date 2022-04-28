package com.sns.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.model.dao.UserDAO;
import com.mystudy.model.vo.EmployeeVO;

public class SearchCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idx = request.getParameter("idx");
		String keyword = request.getParameter("keyword");
		System.out.println(">>> SearchCommand keyword : " + keyword);
		String path = "";
		if (keyword == null || keyword.trim().equals("")) {
			path = "search.jsp";
		} else { // DB데이터 조회 후 결과 페이지 이동
			List<EmployeeVO> list = UserDAO.getSearch(idx, keyword);
			request.setAttribute("list", list);
			path = "searchList.jsp";
		}
		return path;
	}

}
