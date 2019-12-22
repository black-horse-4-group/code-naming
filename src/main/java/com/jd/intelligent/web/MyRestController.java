package com.jd.intelligent.web;

import com.jd.intelligent.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private ReportService reportService;

    @RequestMapping("/report")
    public ResponseEntity<?> report(){
        return new ResponseEntity<Object>(reportService.findTop100WordsHotAndCorrectWeight(), HttpStatus.OK);
    }
}


