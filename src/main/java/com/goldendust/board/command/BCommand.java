package com.goldendust.board.command;

import org.springframework.ui.Model;

public interface BCommand {
	public void execute(Model model);
}
