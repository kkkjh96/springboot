package com.academyinfo.claco.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClacoController {
	public String search(@RequestParam(value="keyword", required=false) String keyword, Model model);
}
