package com.study.board.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

import com.study.board.model.Board;

/* 게시글 작성 유효성 검사*/
@Component
public class BoardValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Board.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Board b = (Board) obj;
		/*값이 비어져 있는지 체크*/
		if(StringUtils.isEmpty(b.getContent())) {
			 errors.rejectValue("content", "key", "내용을 입력하세요!");
		}
	}

}
