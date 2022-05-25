package com.arduino.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Arduino_Tphr")
public class ArduinoEntity {

	@Id
	private String temperature;
	@Column
	private String heartrate;
	@Column
	private Date writedate;
	
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHeartrate() {
		return heartrate;
	}
	public void setHeartrate(String heartrate) {
		this.heartrate = heartrate;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
}
