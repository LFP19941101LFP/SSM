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
	
	/**
	 * 单文件上传
	 * @param username
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam(value="username",required=false) String username,
						 @RequestParam("headerimg") MultipartFile file,
						 Model model) {
		
		System.out.println("文件上传的信息");
		System.out.println("文件的名字(文件项的值): " + file.getName());
		System.out.println("文件的名字(上传文件自己的名字): "  + file.getOriginalFilename());
		// 文件上传
		try {
			file.transferTo(new File("D:\\Photoes\\丫头\\" + file.getOriginalFilename()));
			model.addAttribute("msg", "文件上传成功");
		} catch (Exception e) {
			model.addAttribute("msg", "文件上传失败" + e.getMessage());
		}
		return "forward:/index.jsp";
	}
	
	/**
	 * 多文件上传
	 * @param username
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping("/uploadmore")
	public String uploadMore(@RequestParam(value="username",required=false) String username,
						 	 @RequestParam("headerimg") MultipartFile[] file,
						 	 Model model) {
		
		System.out.println("文件上传的信息");
		for (MultipartFile multipartFile : file) {
			if (!multipartFile.isEmpty()) {
				
				try {
					multipartFile.transferTo(new File("D:\\Photoes\\丫头\\" + multipartFile.getOriginalFilename()));
					model.addAttribute("msg", "文件上传成功");
				} catch (Exception e) {
					model.addAttribute("msg", "文件上传失败" + e.getMessage());
				}
			}
		}
		
		return "forward:/index.jsp";
	}

}
