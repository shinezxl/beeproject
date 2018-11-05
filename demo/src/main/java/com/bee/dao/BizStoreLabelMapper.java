package com.bee.dao;

import com.bee.dao.model.BizStoreLabel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface BizStoreLabelMapper extends Mapper<BizStoreLabel> {
    List queryLabel();
    void updateLabel(@Param("nId") int nId, @Param("labelContext")String labelContext);
}