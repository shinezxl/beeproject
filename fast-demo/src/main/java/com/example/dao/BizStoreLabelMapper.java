package com.example.dao;

import com.example.dao.model.BizStoreLabel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BizStoreLabelMapper extends Mapper<BizStoreLabel> {

    List<BizStoreLabel> selectAllBySql();
}