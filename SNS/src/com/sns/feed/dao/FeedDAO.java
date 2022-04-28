package com.sns.feed.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sns.mybatis.DBService;
import com.sns.vo.BBSVO;
import com.sns.vo.CommentVO;

public class FeedDAO {

	//게시글(BBS_T)의 전체 건수 조회
	public static int getTotalCount() {
		SqlSession ss = DBService.getFactory().openSession();
		int totalCount = ss.selectOne("bbs.totalCount");
		ss.close();
		return totalCount;
	}
	
	//현재 페이지에 해당하는 글목록(게시글) 가져오기
	public static List<FeedVO> getList(int begin, int end) {
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", begin);
		map.put("end", end);
		
		SqlSession ss = DBService.getFactory().openSession();
		List<FeedVO> list = ss.selectList("bbs.list", map);
		ss.close();
		return list;
	}
	//게시글 한개 조회
	public static FeedVO selectOne(int b_idx) {
		SqlSession ss = DBService.getFactory().openSession();
		FeedVO vo = ss.selectOne("bbs.one", b_idx);
		ss.close();
		return vo;
	}
	
	
	//게시글 입력
	public static int insert(BBSVO bvo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("bbs.insert", bvo);
		ss.close();
		return result;
	}
	
	
	
	//========== 댓글 처리 ============
	public static List<CommentVO> getCommList(int b_idx) {
		SqlSession ss = DBService.getFactory().openSession();
		List<CommentVO> list = ss.selectList("bbs.commList", b_idx);
		ss.close();
		return list;
	}
}















