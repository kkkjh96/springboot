package com.jpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.app.domain.MemberEntity;
import com.jpa.app.repository.MemberRepository;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List listMembers() throws Exception {
		return memberRepository.findAll();
	}

	@Override
	public void addMember(MemberEntity member) throws Exception {
		memberRepository.save(member);
	}

	@Override
	public void removeMember(MemberEntity member ) throws Exception {
		memberRepository.delete(member);
	}

	public MemberEntity login(MemberEntity memberEntity) throws Exception {
		return (MemberEntity)memberRepository.getById(memberEntity.getId());
//		if(result==null)
//			 throw processException("info.nodata.msg");
//        return result;
		
//		return memberRepository.findOne(memberEntity);
	}
	
//	@Override
//	public Page<MemberEntity> postMembers(String keyword, Pageable pageable){
//		return null;
//	}

}
