package com.goldendust.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goldendust.board.dao.BoardDao;

public class BViewOneCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bnum = request.getParameter("bnum");
		
		BoardDao bdao = new BoardDao();
		model.addAttribute("bDto", bdao.findById(bnum));

	}

}
