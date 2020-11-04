package com.alibaba.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020-08-21 13:59
 * @company 阿里巴巴
 */
@Controller
public class BookController {

    /**
     * 添加图书
     * @return
     */
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook() {
        System.out.println("添加addBook.....图书");
        return "success";
    }

    /**
     * 查询请求，根据id查询,传入图书的id,从路径中取值
     * @param id 从变量中取值
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String getBook(@PathVariable("bid") Integer id) {
        System.out.println("查询......"+id+"图书");
        return "success";
    }

    /**
     * 更新操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer id) {
        System.out.println("更新......"+id+"图书");
        return "success";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid") Integer id) {
        System.out.println("删除......"+id+"图书");
        return "success";
    }

}
