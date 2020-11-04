package com.spring.down;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileDownController {
	
	
	@RequestMapping("/upload")
	public String upload() {
		
		return "forward:/index.jsp";
	}
	
	
}
