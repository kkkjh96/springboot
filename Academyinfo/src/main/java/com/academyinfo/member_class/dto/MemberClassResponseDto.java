package com.academyinfo.member_class.dto;

import com.academyinfo.member_class.domain.entity.MemberClassEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MemberClassResponseDto {
	private int mcindex;
	
	private Long mindex;
	private int cindex;
	
	@Builder
	public MemberClassResponseDto(int mcindex, Long mindex, int cindex) {
		this.mcindex = mcindex;
		this.mindex = mindex;
		this.cindex = cindex;
	}
	
	@Builder
	public MemberClassResponseDto(MemberClassEntity memberClassEntity) {
		this.mcindex = memberClassEntity.getMcindex();
		this.mindex = memberClassEntity.getMindex().getMindex();
		this.cindex = memberClassEntity.getCindex().getCindex();
	}
}
