package jpa_0509.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa_0509.repository.AcademyRepository;
import jpa_0509.repository.ClassRepository;
import jpa_0509.repository.ImgRepository;
import jpa_0509.repository.MemberRepository;
import jpa_0509.repository.ReviewRepository;


@Service("MemberService")
public class TestServiceImpl implements TestService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ImgRepository imgRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private AcademyRepository academyRepository;
	
	@Override
	public List listMember()
	{
		return memberRepository.findAll();
	}
	
	@Override
	public List findByname(String name)
	{
		return imgRepository.findByName(name);
	}
	
	@Override
	public List listClass()
	{
		return classRepository.findAll();
	}
	
	@Override
	public List listAcademy()
	{
		return academyRepository.findAll();
	}
	/*��õ����(c_status�� approval�̸鼭 ������ ���� ���� 4���� ����) - ���ǳ���*/
	@Override
	public List selectRecommendedCourse()
	{
		return classRepository.selectRecommendedCourse();
	}
	/*��õ����(c_status�� approval�̸鼭 ������ ���� ���� 4���� ����) - ����*/
	@Override
	public List listImg()
	{
		return imgRepository.findAll();
	}
	
	@Override
	public List listReview()
	{
		return reviewRepository.findAll();
	}
	
	/*�ֽ� ���� ������ ���İ˻�*/
	@Override
	public List selectReview()
	{
		return reviewRepository.selectReview();
	}
	
	@Override
	public List findByKeyword(String keyword)
	{
		return classRepository.findByKeyword(keyword);
	}
	
	@Override
	public List findByAddress(String searchType) 
	{
		return academyRepository.findByAddress(searchType);
	}
	
	public List findByLocation(String searchWord)
	{
		return academyRepository.findByLocation(searchWord);
	}
	
	public List findByType(Boolean isComplete, String item)
	{
		return this.findByType(isComplete, item);
	}

}
