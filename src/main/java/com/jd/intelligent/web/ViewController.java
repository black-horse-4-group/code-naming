package com.jd.intelligent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
@Controller
public class ViewController {
    @RequestMapping("/report")
    public String report(){
        return "report";
    }
}
