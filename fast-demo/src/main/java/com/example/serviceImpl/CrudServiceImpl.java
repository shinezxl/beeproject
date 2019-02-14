package com.example.serviceImpl;

import com.example.dao.BizStoreLabelMapper;
import com.example.dao.model.BizStoreLabel;
import com.example.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("crudService")
public class CrudServiceImpl implements CrudService{

    @Autowired
    private BizStoreLabelMapper bizStoreOrgnzMapper;

    @Override
    public List<BizStoreLabel> selectAll() {
//        List<BizStoreLabel> list = bizStoreOrgnzMapper.selectAll();//报错，待解决
        List<BizStoreLabel> list = bizStoreOrgnzMapper.selectAllBySql();
        return list;
    }
}
