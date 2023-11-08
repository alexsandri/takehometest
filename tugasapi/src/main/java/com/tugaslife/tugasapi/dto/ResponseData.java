package com.tugaslife.tugasapi.dto;

import java.util.ArrayList;
import java.util.List;


public class ResponseData<T> {

    // private List<User> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

    private boolean status;
    private List<String> message = new ArrayList<>();
    private T payload;
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public List<String> getMessage() {
        return message;
    }
    public void setMessage(List<String> message) {
        this.message = message;
    }
    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public boolean isLast() {
        return last;
    }
    public void setLast(boolean last) {
        this.last = last;
    }
}
