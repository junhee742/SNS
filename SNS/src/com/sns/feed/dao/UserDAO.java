package com.sns.feed.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mystudy.model.vo.UserVO;
import com.mystudy.mybatis.DBService;

public class UserDAO {

	//전체 직원 목록 조회
	public static List<UserVO> getList() {
		SqlSession ss = DBService.getFactory().openSession();
		List<UserVO> list = ss.selectList("hr.list");
		ss.close();
		return list;
	}
	
	//이름으로 검색
	public static List<UserVO> fullnameList(String fullname) {
		SqlSession ss = DBService.getFactory().openSession();
		List<UserVO> list = ss.selectList("hr.fullnameList", fullname);
		ss.close();
		return list;
	}

	public static List<UserVO> getSearch(String idx, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("idx", idx);
		map.put("keyword", keyword);
		
		SqlSession ss = DBService.getFactory().openSession();
		List<UserVO> list = ss.selectList("hr.search", map);
		ss.close();
		return null;
	}
	
}
