package com.example.ranking.model;
import java.time.*;

public class employee {
	private Integer id;
    private Integer score;
    private LocalDateTime createAt;
    
    public employee() {}
    public employee(Integer id, Integer score, LocalDateTime createAt) {
		super();
    	this.id = id;
    	this.score = score;
    	this.createAt = createAt;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getTime() {
        return createAt;
    }

    public void setAge(LocalDateTime createAt ) {
        this.createAt = createAt;
    }
	@Override
	public String toString() {
		return "Employee [id=" + id + ",score=" + score + "time=" + createAt +"]";
	}
}
