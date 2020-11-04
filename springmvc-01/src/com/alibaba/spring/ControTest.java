package com.alibaba.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020-08-21 9:46
 * @company 阿里巴巴
 */
// 将信息保存在session中,value指定key不推荐使用
// @SessionAttributes(value = "msg快快快")
@Controller   // 告诉spring这是一个处理请求的类
public class ControTest {

    /**
     * 斜杠 / 代表从当前项目下开始,处理当前项目下的hello请求
     * 1.试图解析器自动拼串
     *	 <property name="prefix" value="/WEB-INF/pages/">
     * 	 <property name="suffix" value=".jsp">
     * 2.转发到其他页面:如果要调到其他页面,需要重转发可使用../../
     *   或者return "forward:/hello.jsp",一定要加上 / ,表示从项目根路径
     * 3.重定向到其他页面:return "redirect:/hello.jsp",
     * 4.这两种方式都是用于请求页面和响应页面你不在统一目录下,如:请求页面在pages目录下,
     *   响应页面不在爬个pages下,转发和重定向视图解析器都不会拼串
     */
    @RequestMapping("/hello")
    public String  hello() {
        System.out.println("请求收到,正在处理");
       
        return "forward:/hello.jsp";//此页面在根路径
        // return "success";
    }

    /**
     * @RequestMapping("/user/{id}")获取占位符中的值
     * 表示获取user下的任何任意属性,但只能占一层路径
     * @param id
     * @return
     */
    @RequestMapping("/user/{id}")
    public String  test(@PathVariable("id") String id) {
        System.out.println("占位符" + id);
        return "pathvable";
    }


    /**
     * springmvc将数据带给页面Map<k v>
     * 1.Map讲述带到页面
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(Map<String,Object> map) {
        map.put("msg","您好Map将数据带到页面");
        return "success";
    }


    /**
     * 2.model将数据带到页面
     * @param model
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(Model model) {
        model.addAttribute("msg","你好model将数据带到页面");
        return "success";
    }

    /**
     * 3.modelMap将数据带到页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap) {
        modelMap.addAttribute("msg","你好modelMap将数据带到页面");
        return "success";
    }


    /**
     * 返回值为ModelAndView也可为页面带给数据
     * 视图名就是之前的返回值,返回逻辑视图名,之前返回的字符串
     * @return view
     */
    @RequestMapping("/handle04")
    public ModelAndView handle04() {
        // 首先创建ModelAndView对象,将逻辑视图名
        ModelAndView view = new ModelAndView("success");
        view.addObject("msg","您好使用ModelAndView做返回值");
        return view;
    }

}
