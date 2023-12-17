package com.example.demo.grade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.grade.model.GradeVO;

@Repository
@Mapper
public interface IGradeRepository {
	void			insertGrade(GradeVO gradeVO);
	GradeVO			selectGrade(Long gradeId);
	List<GradeVO>	selectAllGrade();
	int				updateGrade(GradeVO gradeVO);
	int				deleteGrade(GradeVO gradeVO);
}