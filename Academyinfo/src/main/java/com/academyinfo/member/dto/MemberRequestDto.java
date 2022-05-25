package com.academyinfo.member.dto;

import java.util.List;

import com.academyinfo.academy.domain.entity.AcademyEntity;
import com.academyinfo.board.alertboard.domain.entity.AlertBoardEntity;
import com.academyinfo.board.comment.domain.entity.CommentEntity;
import com.academyinfo.board.freeboard.domain.entity.BoardEntity;
import com.academyinfo.member.domain.entity.MemberEntity;
import com.academyinfo.member_class.domain.entity.MemberClassEntity;
import com.academyinfo.review.domain.entity.ReviewEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberRequestDto {
	// Member 관련 내용을 Service >> Entity 전달
	private Long mindex;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String companynum;  // 삭제 예정
	private String address; // 삭제 예정
	private String role;
	
    private AcademyEntity aindex;
	private List<AlertBoardEntity> abindex;
	private List<BoardEntity> fbindex;
	private List<CommentEntity> cmtindex;
	private List<MemberClassEntity> mcindex;
   	private List<ReviewEntity> rvindex;
	 
	public MemberEntity toEntity() {
		MemberEntity memberEntity = MemberEntity.builder()
				 .mindex(mindex)
	             .id(id)
	             .pwd(pwd)
	             .name(name)
	             .phone(phone)
	             .email(email)
	             .companynum(companynum)
	             .address(address) 
	             .role(role)
	             .aindex(aindex)
	             .abindex(abindex)
	             .fbindex(fbindex)
	             .cmtindex(cmtindex)
	             .mcindex(mcindex)
	             .rvindex(rvindex)
	             .build();
		
		return memberEntity;
	}
}
