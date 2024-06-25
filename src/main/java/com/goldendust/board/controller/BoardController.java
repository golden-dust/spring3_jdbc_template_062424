package com.goldendust.board.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goldendust.board.command.BCommand;
import com.goldendust.board.command.BDeleteCommand;
import com.goldendust.board.command.BListCommand;
import com.goldendust.board.command.BModifyCommand;
import com.goldendust.board.command.BViewOneCommand;
import com.goldendust.board.command.BWriteCommand;
import com.goldendust.board.dto.BoardDto;
import com.goldendust.board.util.Constant;

@Controller
public class BoardController {
	
	BCommand command;
	private JdbcTemplate template;
	
	@Autowired	// dependency injection (servlet-context 설정에 있는 기본값을 자동으로 injection해 줌)
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping(value="/write")
	public String toWrite() {
		return "write_form";
	}
	
	@RequestMapping(value="/writeOk")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.execute(model);

		return "redirect:list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value="/content-view")
	public String list(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BViewOneCommand();
		command.execute(model);
		
		
		return "readPost";
	}
	
	@RequestMapping(value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BViewOneCommand();
		command.execute(model);
		
		return "modify_form";
	}
	
	@RequestMapping(value="/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		command.execute(model);
		
		String bnum = request.getParameter("bnum");
		model.addAttribute("bnum", bnum);
		
		return "redirect:content-view";
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		command.execute(model);
		
		return "deleteOk";
	}

}
