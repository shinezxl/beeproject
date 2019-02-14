package com.example.controller;

import com.example.dao.model.BizStoreLabel;
import com.example.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private CrudService crudService;


    @RequestMapping("/selectObj")
    public List<BizStoreLabel> selectObj(){
        List<BizStoreLabel> list = crudService.selectAll();
        return list;
    }

    @RequestMapping("/insertObj")
    public String insertObj(){
        return null;
    }

    @RequestMapping("/updateObj")
    public String updateObj(){
        return null;
    }

    @RequestMapping("/deleteObj")
    public String deleteObj(){
        return null;
    }


}
