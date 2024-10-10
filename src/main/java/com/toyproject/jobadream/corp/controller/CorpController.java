package com.toyproject.jobadream.corp.controller;

import com.toyproject.jobadream.corp.dto.CorpDto;
import com.toyproject.jobadream.corp.service.AllCorpListService;
import com.toyproject.jobadream.corp.service.SpecificCorpSearchService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/corporation")
public class CorpController {

	private final AllCorpListService allCorpListService;
	private final SpecificCorpSearchService specificCorpSearchService;

	public CorpController(AllCorpListService allCorpListService, SpecificCorpSearchService specificCorpSearchService) {
		this.allCorpListService = allCorpListService;
		this.specificCorpSearchService = specificCorpSearchService;
	}

	// 전체 회사 조회
	@GetMapping("/all")
	public List<CorpDto> readAllCorporations() {
		return allCorpListService.getAllCorporations();
	}

	// 특정 회사 조회
	@GetMapping("/specific")
	public CorpDto readCorporation(@RequestParam("id") String id) {
		return specificCorpSearchService.getSpecificCorps(id);
	}
	
	// 응답 오류 Try/Catch 기능 개발 중

	// @GetMapping("/specific/{corpId}")
	// public ResponseEntity<CorpDto> readCorporations(@PathVariable String corpId) {
	// 	try {
	// 		// 서비스 호출 부분에서 명확한 클래스 이름을 사용하도록 변경
	// 		CorpDto corpDto = SpecificCorpSearchService.getSpecificCorpById(corpId);
	//
	// 		// 성공적으로 CorpDto를 가져왔다면 200 OK와 함께 반환
	// 		return ResponseEntity.ok(corpDto);
	// 	} catch (EntityNotFoundException ex) {
	// 		// 예외가 발생했을 때 404 NOT_FOUND와 예외 메시지를 반환
	// 		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	// 	} catch (Exception ex) {
	// 		// 예기치 못한 예외 발생 시 500 INTERNAL_SERVER_ERROR 반환
	// 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	// 	}
	// }


}
//@GetMapping("/aaa/bbb/{corpId}")
// public ResponseEntity<Object> 뭐시기메소드(@PathVariable String corpId) {
//     try {
//         CorpDto corpDto = service.getSpecificCorps(corpId);
//         return ResponseEntity.ok(corpDto); //이 메소드가 맞는지 모르겠음.
//     } catch (Exception ex) {
//         return ResponseEntity.notfound().body(ex.message);
//         // 이것도 모르겠음. 목적은 http status를 404로, body에는 Exception의 message를 담아서 보낼수 있도록. 좀더 객체에 담아도 되긴함.
//         // return ResponseEntity.notfound().body(ErrorMessage.of(ex.message));
//         // ErrorMessage는 에러 래핑용 편의로 만든 클래스
//     }
// }