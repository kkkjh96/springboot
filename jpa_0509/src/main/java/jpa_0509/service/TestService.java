package jpa_0509.service;

import java.util.List;



public interface TestService {
	public List listMember();
	public List findByname(String name);
	public List listClass();
	public List listAcademy();
	public List selectRecommendedCourse();
	public List listImg();
	public List listReview();
	public List selectReview();
	public List findByKeyword(String keyword);
	public List findByAddress(String searchType);
	public List findByLocation(String searchWord);
	public List findByType(Boolean isComplete, String item);

}
