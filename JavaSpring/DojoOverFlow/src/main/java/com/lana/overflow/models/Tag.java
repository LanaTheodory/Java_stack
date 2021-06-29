package com.lana.overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;
@Entity
@Table(name = "tags")
public class Tag {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@NotNull
		@Size(min = 2, max = 255)
		@Pattern(regexp="^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$",message="Tags must be separated by commas, max 3")

		private String tag;
		@Column(updatable = false)
		private Date createdAt;
		private Date updatedAt;
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
		private List<Question> questions;
		
		
		public Tag() {}
		public Tag(String tag, List<Question> questions) {
		
			this.tag = tag;
			this.questions = questions;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}
		public String[] splitTags() {
			return this.tag.split("\\s*,\\s*");
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public List<Question> getQuestions() {
			return questions;
		}

		public void setQuestions(List<Question> questions) {
			this.questions = questions;
		}

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
}
