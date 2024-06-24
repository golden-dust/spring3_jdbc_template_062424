package com.goldendust.board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.goldendust.board.dao.BoardDao;
import com.goldendust.board.dto.BoardDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> boardList = dao.boardDtos();
		
		model.addAttribute("boardList", boardList);
	}

}
