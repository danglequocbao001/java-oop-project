package com.s3rd.java.models;

public class Response {
    public static class Error {
        public String message;
        public Integer code;
    }

    public Object data;
    public Boolean ok;
    public Response.Error error;

    public Response(Object data) {
        this.data = data;
        this.ok = data != null;
    }
}
