package com.bee.controller;

import com.bee.service.LabelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("label")
public class LabelCrudController {
    @Autowired
    private LabelService labelService;

    @RequestMapping("queryLabel")
    public List queryLabel(){
        return labelService.queryLabel();
    }

    @RequestMapping("updateLabel")
    public String updateLabel(@Param("nId") String nId, @Param("labelContext") String labelContext){
         labelService.updateLabel(nId,labelContext);
         return "succeed";
    }

    /**
     * 事务测试
     * @param nId
     * @param labelContext
     * @return
     */
    @RequestMapping("updateLabelTrans")
    public String updateLabelTrans(@Param("nId") String nId, @Param("labelContext") String labelContext){
        labelService.updateLabelTrans(nId,labelContext);
        return "succeed";
    }

}
