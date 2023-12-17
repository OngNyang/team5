package com.example.demo.grade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.grade.model.GradeVO;
import com.example.demo.grade.service.IGradeService;

@RestController
@RequestMapping("/")
public class GradeController {
	private IGradeService gradeService;
	
	@Autowired
	public GradeController(IGradeService gradeService) {
		this.gradeService = gradeService;
	}
	
	@PostMapping("/grade/insert")
	public ResponseEntity<GradeVO> createGrade(@RequestBody GradeVO gradeVO) {
		gradeService.insertGrade(gradeVO);
		return new ResponseEntity<>(gradeVO, HttpStatus.CREATED);
	}
	
	@GetMapping("/grade")
	public ResponseEntity<List<GradeVO>> getAllGrade() {
		List<GradeVO> list = gradeService.selectAllGrade();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/grade/{gradeId}")
	public ResponseEntity<GradeVO> getGradeById(@PathVariable Long gradeId) {
		GradeVO gradeVO = gradeService.selectGrade(gradeId);
		return new ResponseEntity<>(gradeVO, HttpStatus.OK);
	}
	
	@PutMapping("/grade/{gradeId}")
	public ResponseEntity<GradeVO> updateGradeById(@RequestBody GradeVO gradeVO, @PathVariable long gradeId) {
		try {
            GradeVO result = gradeService.updateGradeVO(gradeId, gradeVO);
            
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
        	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
	}
	
	@DeleteMapping("/grade/{gradeId}")
	public ResponseEntity<GradeVO> deleteGradeById(@RequestBody GradeVO gradeVO) {
//		GradeVO deletedGradeVO = gradeService.deleteGradeVO(gradeVO);
//		return new ResponseEntity<>(deletedGradeVO, HttpStatus.OK);
		
		try {
			GradeVO deletedGradeVO = gradeService.deleteGradeVO(gradeVO);
			return new ResponseEntity<>(deletedGradeVO, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
//
//    @PostMapping
//    public ResponseEntity<MovieCreateResponseDto> createMovie(@RequestBody MovieCreateRequestDto movie) {
//        MovieCreateResponseDto createdMovie = movieService.createMovie(movie);
//        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
//
//    }
	
//	@GetMapping("/board/cat/{categoryId}/{page}")
//	public String getListByCategory(@PathVariable int categoryId, @PathVariable int page, HttpSession session, Model model) {
//		session.setAttribute("page", page);
//		model.addAttribute("categoryId", categoryId);
//
//		List<Board> boardList = boardService.selectArticleListByCategory(categoryId, page);
//		model.addAttribute("boardList", boardList);
//
//		int bbsCount = boardService.selectTotalArticleCountByCategoryId(categoryId);
//		int totalPage = 0;
//		if(bbsCount > 0) {
//			totalPage= (int)Math.ceil(bbsCount/10.0);
//		}
//		int totalPageBlock = (int)(Math.ceil(totalPage/10.0));
//		int nowPageBlock = (int) Math.ceil(page/10.0);
//		int startPage = (nowPageBlock-1)*10 + 1;
//		int endPage = 0;
//		if(totalPage > nowPageBlock*10) {
//			endPage = nowPageBlock*10;
//		}else {
//			endPage = totalPage;
//		}
//		model.addAttribute("totalPageCount", totalPage);
//		model.addAttribute("nowPage", page);
//		model.addAttribute("totalPageBlock", totalPageBlock);
//		model.addAttribute("nowPageBlock", nowPageBlock);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		return "board/list";
//	}


}
