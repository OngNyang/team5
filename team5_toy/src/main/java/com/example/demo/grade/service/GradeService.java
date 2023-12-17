package com.example.demo.grade.service;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.grade.dao.IGradeRepository;
import com.example.demo.grade.model.GradeVO;

@Service
public class GradeService implements IGradeService{
	private IGradeRepository gradeRepository;
	
	@Autowired
	public GradeService(IGradeRepository gradeRepository) {
		this.gradeRepository = gradeRepository;	
	}
	
	@Override
	public void			insertGrade(GradeVO gradeVO) {
		gradeRepository.insertGrade(gradeVO);
	}
	
	@Override
	public GradeVO			selectGrade(Long gradeId) {
		return gradeRepository.selectGrade(gradeId);
	}
	
	@Override
	public List<GradeVO>	selectAllGrade(){
		return gradeRepository.selectAllGrade();
	}
	
	@Override
	public GradeVO			updateGradeVO(Long gradeId, GradeVO gradeVO) {
		GradeVO	existingGradeVO = gradeRepository.selectGrade(gradeId);
		
		if (existingGradeVO == null) {
	        throw new DataIntegrityViolationException(null);
	    } else {
	    	GradeVO updatedGradeVO = new GradeVO(gradeId, gradeVO.getGradeName(), gradeVO.getGradeOrder());
	    	gradeRepository.updateGrade(updatedGradeVO);
	    	return updatedGradeVO;
	    }
	}
	
	@Override
	public GradeVO			deleteGradeVO(GradeVO gradeVO) {
		GradeVO existinGradeVO = gradeRepository.selectGrade(gradeVO.getGradeId());
		
		if (existinGradeVO == null || !existinGradeVO.getGradeName().equals(gradeVO.getGradeName()) || existinGradeVO.getGradeOrder() != gradeVO.getGradeOrder()) {
			throw new DataIntegrityViolationException(null);
		} else {
			gradeRepository.deleteGrade(gradeVO);
			return gradeVO;
		}
	}
	
}
