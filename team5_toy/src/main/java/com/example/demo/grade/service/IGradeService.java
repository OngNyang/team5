package com.example.demo.grade.service;

import java.util.List;

import com.example.demo.grade.model.GradeVO;

public interface IGradeService {
	void			insertGrade(GradeVO gradeVO);
	GradeVO			selectGrade(Long gradeId);
	List<GradeVO>	selectAllGrade();
	GradeVO				updateGradeVO(Long gradeId, GradeVO gradeVO);
	GradeVO			deleteGradeVO(GradeVO gradeVO);

}
