package com.sns.vo;

public class CommentVO {
	private String co_idx, writer, content, pwd, regdate,
			ip, b_idx;

	public CommentVO() {}
	public CommentVO(String co_idx, String writer, String content, String pwd, String regdate, String ip,
			String b_idx) {
		super();
		this.co_idx = co_idx;
		this.writer = writer;
		this.content = content;
		this.pwd = pwd;
		this.regdate = regdate;
		this.ip = ip;
		this.b_idx = b_idx;
	}
	public String getco_idx() {
		return co_idx;
	}
	public void setco_idx(String co_idx) {
		this.co_idx = co_idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getWrite_date() {
		return regdate;
	}
	public void setWrite_date(String regdate) {
		this.regdate = regdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getB_idx() {
		return b_idx;
	}
	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}
	@Override
	public String toString() {
		return "CommentVO [co_idx=" + co_idx + ", writer=" + writer + ", content=" + content + ", pwd=" + pwd
				+ ", write_date=" + regdate + ", ip=" + ip + ", b_idx=" + b_idx + "]";
	}
	
}
