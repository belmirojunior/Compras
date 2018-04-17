package br.com.analise.compras.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
    private Integer status;
    private String msg;
    private long timestamp;

    public StandardError(){

    }

    public StandardError(Integer status, String msg, long timestamp) {
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
