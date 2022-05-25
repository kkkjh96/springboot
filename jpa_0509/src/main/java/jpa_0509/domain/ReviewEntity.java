package jpa_0509.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class ReviewEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rv_Index;
	
	@Column
	private Date writedate;
	
	@Column
	private double score;
	
	@Column
	private String contents;
	
	@Column
	private int report;
	
	@Column
	private int m_Index;
	
	@Column
	private String m_Id;
	
	@Column
	private int c_Index;
	
	@Column
	private String c_Name;
	
	@Column
	private double c_Score;

	public Integer getRv_Index() {
		return rv_Index;
	}

	public void setRv_Index(Integer rv_Index) {
		this.rv_Index = rv_Index;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getM_Index() {
		return m_Index;
	}

	public void setM_Index(int m_Index) {
		this.m_Index = m_Index;
	}

	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}

	public int getC_Index() {
		return c_Index;
	}

	public void setC_Index(int c_Index) {
		this.c_Index = c_Index;
	}

	public String getC_Name() {
		return c_Name;
	}

	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}

	public double getC_Score() {
		return c_Score;
	}

	public void setC_Score(double c_Score) {
		this.c_Score = c_Score;
	}
}
