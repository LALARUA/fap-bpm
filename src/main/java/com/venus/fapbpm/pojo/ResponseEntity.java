package com.venus.fapbpm.pojo;

/**
 * 请求回应体
 * @param <T>
 */
public class ResponseEntity<T> {
    /**
     * 回应体头信息
     */
    private Head head = new Head();
    /**
     *  回应体数据
     */
    private T body;

    public ResponseEntity(){
        this(StatusCode.SUCCESS);
    }
    public ResponseEntity(StatusCode responseInfo){
        this.head.setCode(responseInfo.getCode());
        this.head.setMessage(responseInfo.getMessage());
    }
    public void setStatusCode(StatusCode responseInfo){
        this.head.setCode(responseInfo.getCode());
        this.head.setMessage(responseInfo.getMessage());
    }
    public void setData(T data){
        this.body = data;
    }

    public Head getHead() {
        return head;
    }
    public T getBody() {
        return body;
    }
    class Head{
        private Integer code;
        private String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

