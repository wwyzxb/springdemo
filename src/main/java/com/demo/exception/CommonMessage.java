package com.demo.exception;

/**
 * @Author Vincent
 * @Date 2017/11/18 11:46
 */
public interface CommonMessage {
    int getCode();

    String getMessage();

    /**
     * 业务异常编码
     */
    public enum BusinessMessage implements CommonMessage {
        ERROR_UNREGISTER_ACCOUNT(5000, "unregister account"),
        ERROR_WRONGPASSWORD(5001, "wrong password");
        private final int code;
        private final String message;

        BusinessMessage(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    /**
     * 系统异常编码
     */
    public enum SystemMessage implements CommonMessage {
        ERROR_SYSTEM(1000, "system error");
        private final int code;
        private final String message;

        SystemMessage(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
