package com.gottaboy.heart.base.remote;


public class CfgConstant {

    public static Boolean IS_TEST = true; //判断是 true：测试 false：正式
    /**
     * 服务器地址
     */

    public static String SERVER_HOST; //服务器地址

    public static int SUCCEED_CODE=100;
    public static int FAIL_CODE=200;


    static {
        if (IS_TEST) {
            SERVER_HOST = " https://check.cargocn.cn/"; //测试地址
        } else {
            SERVER_HOST = "http://www.cargocn.com/";  //正式地址
        }
    }

    public static final String DISPATCH_LIST = SERVER_HOST + "cargocn-cloud-server/fapi/dispatch/list";
    public static final String DRIVER_LIST = SERVER_HOST + "cargocn-cloud-server/fapi/driver/list";
    public static final String PAYEE_LIST = SERVER_HOST + "cargocn-cloud-server/fapi/payee/list";
    public static final String CODELISTBYCODECATA_LIST = SERVER_HOST + "cargocn-cloud-server/carfreerDriver/getCodeListByCodecata";
    public static final String CAR_ADD = SERVER_HOST + "cargocn-cloud-server/fapi/car/add";
    public static final String DRIVER_ADD = SERVER_HOST + "cargocn-cloud-server/fapi/driver/add";
    public static final String DRIVER_SAVE = SERVER_HOST + "cargocn-cloud-server/fapi/driver/save";
    public static final String DRIVER_UPLOADIDCARD = SERVER_HOST + "cargocn-cloud-server/fapi/driver/uploadIdCard";
    public static final String DRIVER_UPLOADLICENCE = SERVER_HOST + "cargocn-cloud-server/fapi/driver/uploadLicence";
    public static final String PAYEE_ADD = SERVER_HOST + "cargocn-cloud-server/fapi/payee/add";
    public static final String PAYEE_UPLOADBANKCARD = SERVER_HOST + "cargocn-cloud-server/fapi/payee/uploadBankCard";
    public static final String PAYEE_SAVE = SERVER_HOST + "cargocn-cloud-server/fapi/payee/save";
    public static final String DISPATCH_ADDSEND = SERVER_HOST + "cargocn-cloud-server/fapi/dispatch/addSend";

    public static final String DISPATCH_SELECTCARNO = SERVER_HOST + "cargocn-cloud-server/fapi/dispatch/selectCarNo";
    public static final String CAR_SAVE = SERVER_HOST + "cargocn-cloud-server/fapi/car/save";
    public static final String CAR_UPLOADCARVEHICLE = SERVER_HOST + "cargocn-cloud-server/fapi/car/uploadCarVehicle";
    public static final String CAR_UPLOADCARTRANSPORT = SERVER_HOST + "cargocn-cloud-server/fapi/car/uploadCarTransport";
    public static final String PHOTO_DRIVERIDCARD = SERVER_HOST + "cargocn-cloud-server/fapi/photo/driverIdCard";
    public static final String FAPI_DRIVER = SERVER_HOST + "cargocn-cloud-server/fapi/driver/";
    public static final String PHOTO_BANKCARD = SERVER_HOST + "cargocn-cloud-server/fapi/photo/bankCard";
    public static final String ORDER_LIST = SERVER_HOST + "cargocn-cloud-server/fapi/order/list";
    public static final String FAPI_DISPATCH = SERVER_HOST + "cargocn-cloud-server/fapi/dispatch/";
    public static final String DISPATCH_DEPARTURE = SERVER_HOST + "cargocn-cloud-server/fapi/dispatch/departure";
    public static final String DISPATCH_ARRIVE = SERVER_HOST + "cargocn-cloud-server/fapi/dispatch/arrive";
    public static final String DISPATCH_RECEIPT = SERVER_HOST + "cargocn-cloud-server/fapi/dispatch/receipt";
    public static final String FAPI_LOGIN = SERVER_HOST + "cargocn-cloud-server/fapi/login";
    public static final String FAPI_ULOGIN = SERVER_HOST + "cargocn-cloud-server/fapi/ulogin";

    public static final String FAPI_MSGCODE = SERVER_HOST + "cargocn-cloud-server/fapi/msgcode";
    public static final String DRIVER_SEARCHDRIVER = SERVER_HOST + "cargocn-cloud-server/fapi/driver/searchDriver";
    public static final String SHIPPER_LIST = SERVER_HOST + "cargocn-cloud-server/fapi/shipper/list";
    public static final String CAR_SEARCHCAR = SERVER_HOST + "cargocn-cloud-server/fapi/car/searchCar";
    public static final String CAR_LIST = SERVER_HOST + "cargocn-cloud-server/fapi/car/list";
    public static final String STATEMENT_LIST = SERVER_HOST + "cargocn-cloud-pay/driverPay/statement/list";
    public static final String DRIVERPAY_STATEMENT = SERVER_HOST + "cargocn-cloud-pay/driverPay/statement/";
    public static final String STATEMENT_CONFIRM = SERVER_HOST + "cargocn-cloud-pay/statement/confirm";
    public static final String NEWPAYMENT_CONFIRMREQUEST = SERVER_HOST + "cargocn-cloud-pay/newPayment/confirmRequest";

    //https://www.cargocn.com/cargocn-cloud-pay/statement/confirm


}
