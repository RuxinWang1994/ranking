package com.example.ranking.model;
import java.time.*;

public class event {
	
	private Integer id;
	private Integer score;
	private LocalDateTime createAt;
	
	public event() {}
	
	public event(Integer id, Integer score, LocalDateTime createAt) {
		super();
		this.id = id;
		this.score = score;
		this.createAt = createAt;
	}
	
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getScore() {
		return this.score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public LocalDateTime getTime() {
		return this.createAt;
	}
	
	public void setLocalDateTime(LocalDateTime createAt) {
		this.createAt = createAt;
	}

}
