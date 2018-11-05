package com.bee.serviceImpl;

import com.bee.Util.ZxlUntil;
import com.bee.service.LabelService;
import com.bee.dao.BizStoreLabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private BizStoreLabelMapper bizStoreLabelMapper;
    @Override
    public List queryLabel() {
        /*//测试demo-api jar是否可以引用（测试可以）
        String zxl = ZxlUntil.zxl();
        System.out.println(zxl);*/
        return bizStoreLabelMapper.queryLabel();
    }

    @Override
    public void updateLabel(String nId, String labelContext) {
        bizStoreLabelMapper.updateLabel(Integer.valueOf(nId),labelContext);
    }
}
