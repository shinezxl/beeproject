package com.example.service;

import com.example.dao.model.BizStoreLabel;

import java.util.List;

public interface CrudService {
    List<BizStoreLabel> selectAll();
}
