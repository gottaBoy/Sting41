package com.gottaboy.heart.sting41.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/4/4.
 */

public class DeliverBeanAuto implements Serializable {

    /**
     * code : 100
     * data : {"list":[{"id":2,"shipperOrderNo":"11","goodsDetailName":"煤炭","goodsName":"煤炭名字","rateDamage":"0.002","bailorId":11,"bailorName":"货主1","logisticsId":11,"logisticsName":"承运人1","sendProvinceCode":"101000","sendProvinceName":"北京市","sendCityCode":"101001","sendCityName":"北京市","sendRegionCode":"101010","sendRegionName":"大兴区","sendAddressDetail":"崧文路299弄29号302","sendLongitude":120,"sendLatitude":96,"receiveProvinceCode":"100000","receiveProvinceName":"上海市","receiveCityCode":"101000","receiveCityName":"上海市","receiveRegionCode":"100101","receiveRegionName":"长宁区","receiveAddressDetail":"临新路268弄5号楼501","receiveLongitude":120,"receiveLatitude":96,"statusvalue":10,"statustext":0,"creatorId":1,"creatorName":"张三","createTime":"2018-04-03 00:00:00","modifierId":100,"modifierName":"2018-04-02","modifyTime":"2018-04-02 00:00:00","remark":"remark","startTime":null,"endTime":null,"fullSendAddress":"北京市北京市大兴区崧文路299弄29号302","fullReceiveAddress":"上海市上海市长宁区临新路268弄5号楼501"}]}
     * message : 获取数据成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean implements Serializable {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * id : 2
             * shipperOrderNo : 11
             * goodsDetailName : 煤炭
             * goodsName : 煤炭名字
             * rateDamage : 0.002
             * bailorId : 11
             * bailorName : 货主1
             * logisticsId : 11
             * logisticsName : 承运人1
             * sendProvinceCode : 101000
             * sendProvinceName : 北京市
             * sendCityCode : 101001
             * sendCityName : 北京市
             * sendRegionCode : 101010
             * sendRegionName : 大兴区
             * sendAddressDetail : 崧文路299弄29号302
             * sendLongitude : 120
             * sendLatitude : 96
             * receiveProvinceCode : 100000
             * receiveProvinceName : 上海市
             * receiveCityCode : 101000
             * receiveCityName : 上海市
             * receiveRegionCode : 100101
             * receiveRegionName : 长宁区
             * receiveAddressDetail : 临新路268弄5号楼501
             * receiveLongitude : 120
             * receiveLatitude : 96
             * statusvalue : 10
             * statustext : 0
             * creatorId : 1
             * creatorName : 张三
             * createTime : 2018-04-03 00:00:00
             * modifierId : 100
             * modifierName : 2018-04-02
             * modifyTime : 2018-04-02 00:00:00
             * remark : remark
             * startTime : null
             * endTime : null
             * fullSendAddress : 北京市北京市大兴区崧文路299弄29号302
             * fullReceiveAddress : 上海市上海市长宁区临新路268弄5号楼501
             */

            private int id;
            private String shipperOrderNo;
            private String goodsDetailName;
            private String goodsName;
            private String rateDamage;
            private int bailorId;
            private String bailorName;
            private int logisticsId;
            private String logisticsName;
            private String sendProvinceCode;
            private String sendProvinceName;
            private String sendCityCode;
            private String sendCityName;
            private String sendRegionCode;
            private String sendRegionName;
            private String sendAddressDetail;
            private int sendLongitude;
            private int sendLatitude;
            private String receiveProvinceCode;
            private String receiveProvinceName;
            private String receiveCityCode;
            private String receiveCityName;
            private String receiveRegionCode;
            private String receiveRegionName;
            private String receiveAddressDetail;
            private int receiveLongitude;
            private int receiveLatitude;
            private int statusvalue;
            private int statustext;
            private int creatorId;
            private String creatorName;
            private String createTime;
            private int modifierId;
            private String modifierName;
            private String modifyTime;
            private String remark;
            private String startTime;
            private String endTime;
            private String fullSendAddress;
            private String fullReceiveAddress;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getShipperOrderNo() {
                return shipperOrderNo;
            }

            public void setShipperOrderNo(String shipperOrderNo) {
                this.shipperOrderNo = shipperOrderNo;
            }

            public String getGoodsDetailName() {
                return goodsDetailName;
            }

            public void setGoodsDetailName(String goodsDetailName) {
                this.goodsDetailName = goodsDetailName;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getRateDamage() {
                return rateDamage;
            }

            public void setRateDamage(String rateDamage) {
                this.rateDamage = rateDamage;
            }

            public int getBailorId() {
                return bailorId;
            }

            public void setBailorId(int bailorId) {
                this.bailorId = bailorId;
            }

            public String getBailorName() {
                return bailorName;
            }

            public void setBailorName(String bailorName) {
                this.bailorName = bailorName;
            }

            public int getLogisticsId() {
                return logisticsId;
            }

            public void setLogisticsId(int logisticsId) {
                this.logisticsId = logisticsId;
            }

            public String getLogisticsName() {
                return logisticsName;
            }

            public void setLogisticsName(String logisticsName) {
                this.logisticsName = logisticsName;
            }

            public String getSendProvinceCode() {
                return sendProvinceCode;
            }

            public void setSendProvinceCode(String sendProvinceCode) {
                this.sendProvinceCode = sendProvinceCode;
            }

            public String getSendProvinceName() {
                return sendProvinceName;
            }

            public void setSendProvinceName(String sendProvinceName) {
                this.sendProvinceName = sendProvinceName;
            }

            public String getSendCityCode() {
                return sendCityCode;
            }

            public void setSendCityCode(String sendCityCode) {
                this.sendCityCode = sendCityCode;
            }

            public String getSendCityName() {
                return sendCityName;
            }

            public void setSendCityName(String sendCityName) {
                this.sendCityName = sendCityName;
            }

            public String getSendRegionCode() {
                return sendRegionCode;
            }

            public void setSendRegionCode(String sendRegionCode) {
                this.sendRegionCode = sendRegionCode;
            }

            public String getSendRegionName() {
                return sendRegionName;
            }

            public void setSendRegionName(String sendRegionName) {
                this.sendRegionName = sendRegionName;
            }

            public String getSendAddressDetail() {
                return sendAddressDetail;
            }

            public void setSendAddressDetail(String sendAddressDetail) {
                this.sendAddressDetail = sendAddressDetail;
            }

            public int getSendLongitude() {
                return sendLongitude;
            }

            public void setSendLongitude(int sendLongitude) {
                this.sendLongitude = sendLongitude;
            }

            public int getSendLatitude() {
                return sendLatitude;
            }

            public void setSendLatitude(int sendLatitude) {
                this.sendLatitude = sendLatitude;
            }

            public String getReceiveProvinceCode() {
                return receiveProvinceCode;
            }

            public void setReceiveProvinceCode(String receiveProvinceCode) {
                this.receiveProvinceCode = receiveProvinceCode;
            }

            public String getReceiveProvinceName() {
                return receiveProvinceName;
            }

            public void setReceiveProvinceName(String receiveProvinceName) {
                this.receiveProvinceName = receiveProvinceName;
            }

            public String getReceiveCityCode() {
                return receiveCityCode;
            }

            public void setReceiveCityCode(String receiveCityCode) {
                this.receiveCityCode = receiveCityCode;
            }

            public String getReceiveCityName() {
                return receiveCityName;
            }

            public void setReceiveCityName(String receiveCityName) {
                this.receiveCityName = receiveCityName;
            }

            public String getReceiveRegionCode() {
                return receiveRegionCode;
            }

            public void setReceiveRegionCode(String receiveRegionCode) {
                this.receiveRegionCode = receiveRegionCode;
            }

            public String getReceiveRegionName() {
                return receiveRegionName;
            }

            public void setReceiveRegionName(String receiveRegionName) {
                this.receiveRegionName = receiveRegionName;
            }

            public String getReceiveAddressDetail() {
                return receiveAddressDetail;
            }

            public void setReceiveAddressDetail(String receiveAddressDetail) {
                this.receiveAddressDetail = receiveAddressDetail;
            }

            public int getReceiveLongitude() {
                return receiveLongitude;
            }

            public void setReceiveLongitude(int receiveLongitude) {
                this.receiveLongitude = receiveLongitude;
            }

            public int getReceiveLatitude() {
                return receiveLatitude;
            }

            public void setReceiveLatitude(int receiveLatitude) {
                this.receiveLatitude = receiveLatitude;
            }

            public int getStatusvalue() {
                return statusvalue;
            }

            public void setStatusvalue(int statusvalue) {
                this.statusvalue = statusvalue;
            }

            public int getStatustext() {
                return statustext;
            }

            public void setStatustext(int statustext) {
                this.statustext = statustext;
            }

            public int getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(int creatorId) {
                this.creatorId = creatorId;
            }

            public String getCreatorName() {
                return creatorName;
            }

            public void setCreatorName(String creatorName) {
                this.creatorName = creatorName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getModifierId() {
                return modifierId;
            }

            public void setModifierId(int modifierId) {
                this.modifierId = modifierId;
            }

            public String getModifierName() {
                return modifierName;
            }

            public void setModifierName(String modifierName) {
                this.modifierName = modifierName;
            }

            public String getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(String modifyTime) {
                this.modifyTime = modifyTime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getFullSendAddress() {
                return fullSendAddress;
            }

            public void setFullSendAddress(String fullSendAddress) {
                this.fullSendAddress = fullSendAddress;
            }

            public String getFullReceiveAddress() {
                return fullReceiveAddress;
            }

            public void setFullReceiveAddress(String fullReceiveAddress) {
                this.fullReceiveAddress = fullReceiveAddress;
            }
        }
    }
}
