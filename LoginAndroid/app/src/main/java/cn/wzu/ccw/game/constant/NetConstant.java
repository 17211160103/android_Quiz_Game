package cn.wzu.ccw.game.constant;

public class NetConstant {


//    public static final String baseService = "http://192.168.104.201:8090";
    public static final String baseService = "http://172.20.10.2:8090";
//    public static final String baseService = "http://192.168.43.8:8090";

    private static final String getOtpCodeURL     = "/user/getOtp";
    private static final String loginURL          = "/user/login";
    private static final String registerURL       = "/user/register";
    private static final String createItemURL     = "/item/create";
    private static final String getItemListURL    = "/item/list";
    private static final String submitOrderURL    = "/order/createorder";
    private static final String getQuesURL    = "/ques/getQuestion";

    private static final String getNewsListURL = "/news/list";

    private static final String getNewsByIdURL = "/news/detail/id?id=";

    private static final String getNewsByTitleURL = "/news/detail/title?title=";

    public static String getGetQuesURL(){return baseService+getQuesURL;}
    public static String getGetOtpCodeURL() {
        return getOtpCodeURL;
    }

    public static String getLoginURL() {
        return baseService+loginURL;
    }

    public static String getRegisterURL() {
        return baseService+registerURL;
    }

    public static String getCreateItemURL() {
        return createItemURL;
    }

    public static String getGetItemListURL() {
        return getItemListURL;
    }

    public static String getSubmitOrderURL() {
        return submitOrderURL;
    }

    public static String getNewsListURL() {
        return getNewsListURL;
    }

    public static String getNewsByIdURL() {
        return getNewsByIdURL;
    }

    public static String getNewsByTitleURL() {
        return getNewsByTitleURL;
    }


}
