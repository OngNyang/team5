package com.example.demo.grade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GradeVO {
	private long	gradeId;
	private String	gradeName;
	private int		gradeOrder;
}
