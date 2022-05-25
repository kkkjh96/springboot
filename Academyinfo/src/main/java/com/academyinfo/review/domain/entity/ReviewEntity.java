package com.academyinfo.review.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.academyinfo.Class.domain.entity.ClassEntity;
import com.academyinfo.common.entity.TimeEntity;
import com.academyinfo.member.domain.entity.MemberEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="review")
public class ReviewEntity extends TimeEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rvindex;
	
	@Column
	private double score;
	
	@Column
	private String contents;
	
	/* 신고 카운트 */
	@Column(columnDefinition = "integer default 0")
	private int report;
	
	// Class 테이블과 N:1 
	@ManyToOne
	@JoinColumn(name = "cindex")
	private ClassEntity cindex;
	
	/* 
	 * >> 강의 이름
	 * @Column
	 * private String cname;
	 * 
	*/
	
	// Member 테이블과 N:1
	@ManyToOne
	@JoinColumn(name = "mindex")
	private MemberEntity mindex;
	
	/* >> 작성자
	@Column
	private String mid;
	*/

	@Builder
	public ReviewEntity(Integer rvindex, double score, String contents, int report, LocalDateTime createdDate, LocalDateTime modifiedDate, ClassEntity cindex, MemberEntity mindex) {
		this.rvindex = rvindex;
		this.score = score;
		this.contents = contents;
		this.report = report;
		this.cindex = cindex;
		this.mindex = mindex;
	}
}
