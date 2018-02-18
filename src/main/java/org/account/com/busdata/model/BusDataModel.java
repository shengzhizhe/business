package org.account.com.busdata.model;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @name 商家账户资料
 * @table account_table
 */
public class BusDataModel implements Serializable {
    //    主键
    private String uuid;
    //    账号
    @NotBlank(message = "账号不能为空", groups = {ADD.class, UPDATE.class})
    private String account;
    //商家名称
    private String businesnames;
    //营业执照
    private String licenseImg;
    //法人
    private String legalperson;
    //法人身份证号
    private String legalpersonIdNumber;
    //法人电话
    private String legalpersonPhone;
    //法人手机
    private String legalpersonTelephone;
    //商家客服电话
    private String servicePhone;
    //营业场所地址
    private String shopAddress;
    //经营范围 (行业表主键)
    private String scopeOperation;
    //行业许可证
    private String industryLicense;
    //商家类型
    private String businessType;

    public BusDataModel() {
    }

    public BusDataModel(String uuid, String account, String businesnames, String licenseImg, String legalperson, String legalpersonIdNumber, String legalpersonPhone, String legalpersonTelephone, String servicePhone, String shopAddress, String scopeOperation, String industryLicense, String businessType) {
        this.uuid = uuid;
        this.account = account;
        this.businesnames = businesnames;
        this.licenseImg = licenseImg;
        this.legalperson = legalperson;
        this.legalpersonIdNumber = legalpersonIdNumber;
        this.legalpersonPhone = legalpersonPhone;
        this.legalpersonTelephone = legalpersonTelephone;
        this.servicePhone = servicePhone;
        this.shopAddress = shopAddress;
        this.scopeOperation = scopeOperation;
        this.industryLicense = industryLicense;
        this.businessType = businessType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBusinesnames() {
        return businesnames;
    }

    public void setBusinesnames(String businesnames) {
        this.businesnames = businesnames;
    }

    public String getLicenseImg() {
        return licenseImg;
    }

    public void setLicenseImg(String licenseImg) {
        this.licenseImg = licenseImg;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    public String getLegalpersonIdNumber() {
        return legalpersonIdNumber;
    }

    public void setLegalpersonIdNumber(String legalpersonIdNumber) {
        this.legalpersonIdNumber = legalpersonIdNumber;
    }

    public String getLegalpersonPhone() {
        return legalpersonPhone;
    }

    public void setLegalpersonPhone(String legalpersonPhone) {
        this.legalpersonPhone = legalpersonPhone;
    }

    public String getLegalpersonTelephone() {
        return legalpersonTelephone;
    }

    public void setLegalpersonTelephone(String legalpersonTelephone) {
        this.legalpersonTelephone = legalpersonTelephone;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getScopeOperation() {
        return scopeOperation;
    }

    public void setScopeOperation(String scopeOperation) {
        this.scopeOperation = scopeOperation;
    }

    public String getIndustryLicense() {
        return industryLicense;
    }

    public void setIndustryLicense(String industryLicense) {
        this.industryLicense = industryLicense;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "BusDataModel{" +
                "uuid='" + uuid + '\'' +
                ", account='" + account + '\'' +
                ", businesnames='" + businesnames + '\'' +
                ", licenseImg='" + licenseImg + '\'' +
                ", legalperson='" + legalperson + '\'' +
                ", legalpersonIdNumber='" + legalpersonIdNumber + '\'' +
                ", legalpersonPhone='" + legalpersonPhone + '\'' +
                ", legalpersonTelephone='" + legalpersonTelephone + '\'' +
                ", servicePhone='" + servicePhone + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", scopeOperation='" + scopeOperation + '\'' +
                ", industryLicense='" + industryLicense + '\'' +
                ", businessType='" + businessType + '\'' +
                '}';
    }
}
