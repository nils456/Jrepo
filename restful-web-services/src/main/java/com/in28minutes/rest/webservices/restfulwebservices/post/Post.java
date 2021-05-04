package com.in28minutes.rest.webservices.restfulwebservices.post;
import java.util.Date;

public class Post {

		private Integer id;

		private String title;

		private Date createDate;
		
		private String content;
		
		private Integer userId;
		
		protected Post() {
			
		}
		public Post(Integer id, String title, Date createDate, String content, Integer userId) {
			super();
			this.id = id;
			this.title = title;
			this.createDate = createDate;
			this.content = content;
			this.userId = userId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate() {
			this.createDate = new Date();
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		
		@Override
		public String toString() {
			return String.format("[Post id=%s, title=%s, CreateDate=%s, Content=%s, Author id=%s ]", id, title,createDate, content, userId);
		}
}
 