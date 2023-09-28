package com.taskscheduler.TaskScheduler.modelsResponse;

public class StatusResponse {

    public boolean status;
    public String message;
    public Object data;

    public StatusResponse() {
    }

    public StatusResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public StatusResponse(boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseStructure{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
