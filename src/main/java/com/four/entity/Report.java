package com.four.entity;

import java.util.Date;

public class Report {
    int reportId;                   //举报信息id
    String reporterUserName;        //举报人
    String beReporter;              //被举报人
    String reportInfo;              //举报信息
    String reportStatus;            //审核状态
    Date   reportDate;              //举报日期
    String reportReply;              //举报结果

    public int getReportId() {
        return reportId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public Report(int reportId, String reporterUserName, String beReporter, String reportInfo, String reportStatus, Date reportDate, String reportReply) {
        this.reportId = reportId;
        this.reporterUserName = reporterUserName;
        this.beReporter = beReporter;
        this.reportInfo = reportInfo;
        this.reportStatus = reportStatus;
        this.reportDate = reportDate;
        this.reportReply = reportReply;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReporterUserName() {
        return reporterUserName;
    }

    public void setReporterUserName(String reporterUserName) {
        this.reporterUserName = reporterUserName;
    }


    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reporterUserName='" + reporterUserName + '\'' +
                ", beReporter='" + beReporter + '\'' +
                ", reportInfo='" + reportInfo + '\'' +
                ", reportStatus='" + reportStatus + '\'' +
                ", reportDate=" + reportDate +
                ", reportReply='" + reportReply + '\'' +
                '}';
    }

    public String getReportReply() {
        return reportReply;
    }

    public void setReportReply(String reportReply) {
        this.reportReply = reportReply;
    }

    public Report() {
    }

    public String getBeReporter() {
        return beReporter;
    }

    public void setBeReporter(String beReporter) {
        this.beReporter = beReporter;
    }

    public String getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(String reportInfo) {
        this.reportInfo = reportInfo;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
}
