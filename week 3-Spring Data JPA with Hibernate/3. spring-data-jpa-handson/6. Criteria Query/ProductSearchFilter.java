package com.cognizant.orm_learn.model;

public class ProductSearchFilter {

    private String keyword;
    private String ramSize;
    private String cpu;
    private String os;
    private Double maxWeight;
    private String customerReview;
    private Double minCpuSpeed;
    private String hardDiskSize;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getCustomerReview() {
        return customerReview;
    }

    public void setCustomerReview(String customerReview) {
        this.customerReview = customerReview;
    }

    public Double getMinCpuSpeed() {
        return minCpuSpeed;
    }

    public void setMinCpuSpeed(Double minCpuSpeed) {
        this.minCpuSpeed = minCpuSpeed;
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

}
