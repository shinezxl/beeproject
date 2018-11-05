package com.bee.service;

import java.util.List;

public interface LabelService {
    List queryLabel();

    void updateLabel(String nId, String labelContext);

    void updateLabelTrans(String nId, String labelContext);

}
