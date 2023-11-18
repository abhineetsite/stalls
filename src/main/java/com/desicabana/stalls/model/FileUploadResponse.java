package com.desicabana.stalls.model;
public class FileUploadResponse {
    private String status;
    private String message;
    private String filePath;

    public FileUploadResponse() {
    }

    public FileUploadResponse(String status, String message, String filePath) {
        this.status = status;
        this.message = message;
        this.filePath = filePath;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override

    public String toString() {
        return "FileUploadResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

}