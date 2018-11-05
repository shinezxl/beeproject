package com.bee.serviceImpl;

import com.bee.service.LabelService;
import com.bee.dao.BizStoreLabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private BizStoreLabelMapper bizStoreLabelMapper;
    @Override
    public List queryLabel() {
        return bizStoreLabelMapper.queryLabel();
    }

    @Override
    public void updateLabel(String nId, String labelContext) {
        bizStoreLabelMapper.updateLabel(Integer.valueOf(nId),labelContext);
    }
    //事务无效原因解析 https://www.cnblogs.com/milton/p/6046699.html
    @Transactional
    @Override
    public void updateLabelTrans(String nId, String labelContext) {
        updateLabel(nId,labelContext+"1");
        if (labelContext.equals("yichang")){
            int a = 1/0;
        }
        updateLabel(String.valueOf(Integer.valueOf(nId)+1),labelContext+"2");
    }
}
