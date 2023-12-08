package com.capg.entity;

import  java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="test_management")
public class TestManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_mgmt_id")
	private int testManagementId;
	@Column(name="user_id")
	private int userId;
	@Column(name="test_id")
	private int testId;
	@Column(name="test_duration")
	private long testDuration;
	@Column(name="start_date_time")
	private LocalDateTime startDateTime;
	@Column(name="end_date_time")
	private LocalDateTime endDateTime;
	
	public TestManagement(int userId, int testId, long testDuration) {
		super();
		this.userId = userId;
		this.testId = testId;
		this.testDuration = testDuration;
		this.startDateTime = LocalDateTime.now();
		this.endDateTime = startDateTime.plusMinutes(testDuration);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public long getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(long testDuration) {
		this.testDuration = testDuration;
	}
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	
}
