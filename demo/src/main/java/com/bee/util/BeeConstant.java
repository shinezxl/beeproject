package com.bee.util;

import com.google.common.collect.Maps;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;

public class BeeConstant {

    public static final String SYS_STR = "系统常量";
    public static final Boolean SYS_BOO = Boolean.TRUE;


    public class SmsType{

        public final static String vercode = "1";

    }


    public enum LoginPlatform{
        HAOLINJU("1"),
        SUPER_G("2")
        ;


        private String type;

        LoginPlatform(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }


    public enum ActionApi{
        红包明细获取("gebon"),
        会员信息获取("gememb"),
        会员注册("crmemb"),
        手机号绑定("chmobi"),
        手机号获取红包("gebonbyphone")
        ;

        private String api;

        ActionApi(String api) {
            this.api = api;
        }

        public String getApi() {
            return api;
        }

        @Override
        public String toString() {
            return api;
        }
    }


    public static final Map<String,String> CODE;
    static {
        CODE = Maps.newHashMap();
        CODE.put("0","系统错误");
        CODE.put("10000","操作成功");
        CODE.put("10001","appkey不能为空");
        CODE.put("10002","appkey用户不存在");
        CODE.put("10003","sign不能为空");
        CODE.put("10004","签名失败");
        CODE.put("10005","业务参数不全");
        CODE.put("10006","数据为空");
        CODE.put("10007","该用户不是会员");
        CODE.put("10008","手机号码不正确");
        CODE.put("10009","创建用户失败");
        CODE.put("10010","红包领取失败");
        CODE.put("10011","红包活动ID不正确");
        CODE.put("10012","业务接口错误/权限不足");

    }


    public static void main(String[] args) {
        LoginPlatform haolinju = BeeConstant.LoginPlatform.HAOLINJU;
        System.out.println(JSONArray.fromObject(haolinju).toString());


        ActionApi 红包明细获取 = BeeConstant.ActionApi.红包明细获取;
        System.out.println(JSONArray.fromObject(红包明细获取).toString());
    }
}
