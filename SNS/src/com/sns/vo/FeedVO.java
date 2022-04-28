package com.sns.vo;

// BBSVO, BbsVO, BbsVo
public class FeedVO {
	private String b_idx, writer, content, file_name,
			ori_name, write_date, like;

	public FeedVO() {}
	public FeedVO(String b_idx, String writer, String content, String file_name, String ori_name,
				String write_date, String like) {
		super();
		this.b_idx = b_idx;
		this.writer = writer;
		this.content = content;
		this.file_name = file_name;
		this.ori_name = ori_name;
		this.write_date = write_date;
		this.like = like;
	}
	
	public String getB_idx() {
		return b_idx;
	}
	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
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
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getOri_name() {
		return ori_name;
	}
	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	
	public String getlike() {
		return like;
	}
	public void setlike(String like) {
		this.like = like;
	}
	@Override
	public String toString() {
		return "BBSVO [b_idx=" + b_idx + ", writer=" + writer + ", content=" + content
				+ ", file_name=" + file_name + ", ori_name=" + ori_name + ", write_date=" + write_date
				+ ", like=" + like + "]";
	}
	
	
}
