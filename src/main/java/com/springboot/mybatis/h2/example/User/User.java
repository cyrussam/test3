package com.springboot.mybatis.h2.example.User;

public class User {
	private Long id;
	private String name;
	private Long score;

	public User() {
		super();
	}

	public User(Long id, String name, Long score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public User(String name,Long score) {
		super();
		this.name = name;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, score=%s]", id, name, score);
	}

}
