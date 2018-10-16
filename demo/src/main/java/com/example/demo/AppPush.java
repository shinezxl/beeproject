package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class AppPush {

    /*private IPushResult getPushMessage(JSONObject jsonObject ){
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        // 定义"点击链接打开通知模板"，并设置标题、内容、链接
        NotificationTemplate template = new NotificationTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTransmissionType(1);

        template.setTransmissionContent(jsonObject.toString());

        template.setAppId(appId);
        template.setAppkey(appKey);

        Style0 style = new Style0();
        // 设置通知栏标题和内容
        style.setTitle(jsonObject.getString("title"));
        style.setText(jsonObject.getString("desc"));
        // 设置通知，响铃、震动、可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        // 设置
        template.setStyle(style);
        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        return ret;
    }*/
}
