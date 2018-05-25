package com.gottaboy.heart.sting41.bean;

/**
 * Created by Administrator on 2018/4/4.
 */

public class LoginBean {

    /**
     * code : 100
     * msg : success
     * data : {"sessionID":"4f9ee149-832e-4119-b438-9b402692c814","user":{"id":1822,"organizationId":1024,"username":"13814175457","password":"ff80135d2390283e94bc91de2757bb82","salt":"f8cd4a74dac2c93f6d5d41954eef6523","locked":false,"really_name":"丁杰","emailAddr":"dingjie@cargocn.com","userTel":"13814175457","companyName":null,"verify_status":null,"remark":null,"weChatId":null,"wechatUnionID":null,"weChatHhgopenId":null,"failLoginTimes":0,"credentialsSalt":"13814175457f8cd4a74dac2c93f6d5d41954eef6523"}}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sessionID : 4f9ee149-832e-4119-b438-9b402692c814
         * user : {"id":1822,"organizationId":1024,"username":"13814175457","password":"ff80135d2390283e94bc91de2757bb82","salt":"f8cd4a74dac2c93f6d5d41954eef6523","locked":false,"really_name":"丁杰","emailAddr":"dingjie@cargocn.com","userTel":"13814175457","companyName":null,"verify_status":null,"remark":null,"weChatId":null,"wechatUnionID":null,"weChatHhgopenId":null,"failLoginTimes":0,"credentialsSalt":"13814175457f8cd4a74dac2c93f6d5d41954eef6523"}
         */

        private String sessionID;
        private UserBean user;

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : 1822
             * organizationId : 1024
             * username : 13814175457
             * password : ff80135d2390283e94bc91de2757bb82
             * salt : f8cd4a74dac2c93f6d5d41954eef6523
             * locked : false
             * really_name : 丁杰
             * emailAddr : dingjie@cargocn.com
             * userTel : 13814175457
             * companyName : null
             * verify_status : null
             * remark : null
             * weChatId : null
             * wechatUnionID : null
             * weChatHhgopenId : null
             * failLoginTimes : 0
             * credentialsSalt : 13814175457f8cd4a74dac2c93f6d5d41954eef6523
             */

            private int id;
            private int organizationId;
            private String username;
            private String password;
            private String salt;
            private boolean locked;
            private String really_name;
            private String emailAddr;
            private String userTel;
            private String companyName;
            private String verify_status;
            private String remark;
            private String weChatId;
            private String wechatUnionID;
            private String weChatHhgopenId;
            private int failLoginTimes;
            private String credentialsSalt;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrganizationId() {
                return organizationId;
            }

            public void setOrganizationId(int organizationId) {
                this.organizationId = organizationId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public boolean isLocked() {
                return locked;
            }

            public void setLocked(boolean locked) {
                this.locked = locked;
            }

            public String getReally_name() {
                return really_name==null?"":really_name;
            }

            public void setReally_name(String really_name) {
                this.really_name = really_name;
            }

            public String getEmailAddr() {
                return emailAddr;
            }

            public void setEmailAddr(String emailAddr) {
                this.emailAddr = emailAddr;
            }

            public String getUserTel() {
                return userTel;
            }

            public void setUserTel(String userTel) {
                this.userTel = userTel;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getVerify_status() {
                return verify_status;
            }

            public void setVerify_status(String verify_status) {
                this.verify_status = verify_status;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getWeChatId() {
                return weChatId;
            }

            public void setWeChatId(String weChatId) {
                this.weChatId = weChatId;
            }

            public String getWechatUnionID() {
                return wechatUnionID;
            }

            public void setWechatUnionID(String wechatUnionID) {
                this.wechatUnionID = wechatUnionID;
            }

            public String getWeChatHhgopenId() {
                return weChatHhgopenId;
            }

            public void setWeChatHhgopenId(String weChatHhgopenId) {
                this.weChatHhgopenId = weChatHhgopenId;
            }

            public int getFailLoginTimes() {
                return failLoginTimes;
            }

            public void setFailLoginTimes(int failLoginTimes) {
                this.failLoginTimes = failLoginTimes;
            }

            public String getCredentialsSalt() {
                return credentialsSalt;
            }

            public void setCredentialsSalt(String credentialsSalt) {
                this.credentialsSalt = credentialsSalt;
            }
        }
    }
}
