package com.example.demo.grade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeVO {
	private long	gradeId;
	private String	gradeName;
	private int		gradeOrder;
}
