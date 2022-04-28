package com.sns.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.model.dao.UserDAO;
import com.mystudy.model.vo.EmployeeVO;

public class FullnameListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 파라미터 값 추출(확인)
		String fullname = request.getParameter("fullname");
		
		//1. DB데이터 조회하고 가져오기
		List<EmployeeVO> list = UserDAO.fullnameList(fullname);
		//2. DB데이터 request scope에 저장
		request.setAttribute("list", list);
		//3. fullnameList.jsp 페이지로 위임(전달) 처리
		//request.getRequestDispatcher("fullnameList.jsp").forward(request, response);
		return "fullnameList.jsp";
	}

}
