package com.zyj.leetcode.business.order.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurOrder {
    private Long id;

    private String billNo;

    private Date billDate;

    private Date planReceiveDate;

    private Long supplierId;

    private String supplierAddress;

    private String linkman;

    private String telephone;

    private String accountMode;

    private String tradNo;

    private Byte purchaseType;

    private Byte enableQuality;

    private BigDecimal taxRate;

    private BigDecimal notaxAmount;

    private BigDecimal taxAmount;

    private BigDecimal tax;

    private Long personId;

    private String remark;

    private Byte enableApprove;

    private Byte approveStatus;

    private Byte currentState;

    private Long createrId;

    private Long lastModifierId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte delFlag;

    private Long tenantId;

    private Long businessId;

    private Long shopId;

    private Long authorizerId;

    private Long authorizerDeptId;

    private String processInstanceId;

    private Boolean processInstanceStatus;

    private Long lastCloseId;

    private Date gmtClose;

    private Long paymentTermId;

    private Byte publishState;

    private Long changId;

    private Long taxId;

    private Long currencyId;

    private String currencyName;

    private Long purchaseTypeBusinessId;

    private Long createdShopId;

    private Byte urge;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    private String attribute7;

    private String attribute8;

    private String attribute9;

    private String attribute10;

    private String attribute11;

    private String attribute12;

    private String attribute13;

    private String attribute14;

    private String attribute15;

    private String attribute16;

    private String attribute17;

    private String attribute18;

    private String attribute19;

    private String attribute20;

    private String attribute21;

    private String attribute22;

    private String attribute23;

    private String attribute24;

    private String attribute25;

    private String attribute26;

    private String attribute27;

    private String attribute28;

    private String attribute29;

    private String attribute30;

    private String attribute31;

    private String attribute32;

    private String attribute33;

    private String attribute34;

    private String attribute35;

    private String attribute36;

    private String attribute37;

    private String attribute38;

    private String attribute39;

    private String attribute40;

    private String attribute41;

    private String attribute42;

    private String attribute43;

    private String attribute44;

    private String attribute45;

    private String attribute46;

    private String attribute47;

    private String attribute48;

    private String attribute49;

    private String attribute50;

    private Byte writeBackStatus;

    private String failReason;

    private Byte failReasonType;

    private Long supplierPoolId;

    private Date gmtCloseCancel;

    private Long lastCancelId;

    private BigDecimal notaxLocalAmount;

    private BigDecimal taxLocalAmount;

    private BigDecimal localTax;

    private BigDecimal exchangeRate;

    private String attachment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getPlanReceiveDate() {
        return planReceiveDate;
    }

    public void setPlanReceiveDate(Date planReceiveDate) {
        this.planReceiveDate = planReceiveDate;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAccountMode() {
        return accountMode;
    }

    public void setAccountMode(String accountMode) {
        this.accountMode = accountMode == null ? null : accountMode.trim();
    }

    public String getTradNo() {
        return tradNo;
    }

    public void setTradNo(String tradNo) {
        this.tradNo = tradNo == null ? null : tradNo.trim();
    }

    public Byte getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(Byte purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Byte getEnableQuality() {
        return enableQuality;
    }

    public void setEnableQuality(Byte enableQuality) {
        this.enableQuality = enableQuality;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getNotaxAmount() {
        return notaxAmount;
    }

    public void setNotaxAmount(BigDecimal notaxAmount) {
        this.notaxAmount = notaxAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getEnableApprove() {
        return enableApprove;
    }

    public void setEnableApprove(Byte enableApprove) {
        this.enableApprove = enableApprove;
    }

    public Byte getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Byte approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Byte getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Byte currentState) {
        this.currentState = currentState;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public Long getLastModifierId() {
        return lastModifierId;
    }

    public void setLastModifierId(Long lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(Long authorizerId) {
        this.authorizerId = authorizerId;
    }

    public Long getAuthorizerDeptId() {
        return authorizerDeptId;
    }

    public void setAuthorizerDeptId(Long authorizerDeptId) {
        this.authorizerDeptId = authorizerDeptId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public Boolean getProcessInstanceStatus() {
        return processInstanceStatus;
    }

    public void setProcessInstanceStatus(Boolean processInstanceStatus) {
        this.processInstanceStatus = processInstanceStatus;
    }

    public Long getLastCloseId() {
        return lastCloseId;
    }

    public void setLastCloseId(Long lastCloseId) {
        this.lastCloseId = lastCloseId;
    }

    public Date getGmtClose() {
        return gmtClose;
    }

    public void setGmtClose(Date gmtClose) {
        this.gmtClose = gmtClose;
    }

    public Long getPaymentTermId() {
        return paymentTermId;
    }

    public void setPaymentTermId(Long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public Byte getPublishState() {
        return publishState;
    }

    public void setPublishState(Byte publishState) {
        this.publishState = publishState;
    }

    public Long getChangId() {
        return changId;
    }

    public void setChangId(Long changId) {
        this.changId = changId;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName == null ? null : currencyName.trim();
    }

    public Long getPurchaseTypeBusinessId() {
        return purchaseTypeBusinessId;
    }

    public void setPurchaseTypeBusinessId(Long purchaseTypeBusinessId) {
        this.purchaseTypeBusinessId = purchaseTypeBusinessId;
    }

    public Long getCreatedShopId() {
        return createdShopId;
    }

    public void setCreatedShopId(Long createdShopId) {
        this.createdShopId = createdShopId;
    }

    public Byte getUrge() {
        return urge;
    }

    public void setUrge(Byte urge) {
        this.urge = urge;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3 == null ? null : attribute3.trim();
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4 == null ? null : attribute4.trim();
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5 == null ? null : attribute5.trim();
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6 == null ? null : attribute6.trim();
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7 == null ? null : attribute7.trim();
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8 == null ? null : attribute8.trim();
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9 == null ? null : attribute9.trim();
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10 == null ? null : attribute10.trim();
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11 == null ? null : attribute11.trim();
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12 == null ? null : attribute12.trim();
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13 == null ? null : attribute13.trim();
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14 == null ? null : attribute14.trim();
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15 == null ? null : attribute15.trim();
    }

    public String getAttribute16() {
        return attribute16;
    }

    public void setAttribute16(String attribute16) {
        this.attribute16 = attribute16 == null ? null : attribute16.trim();
    }

    public String getAttribute17() {
        return attribute17;
    }

    public void setAttribute17(String attribute17) {
        this.attribute17 = attribute17 == null ? null : attribute17.trim();
    }

    public String getAttribute18() {
        return attribute18;
    }

    public void setAttribute18(String attribute18) {
        this.attribute18 = attribute18 == null ? null : attribute18.trim();
    }

    public String getAttribute19() {
        return attribute19;
    }

    public void setAttribute19(String attribute19) {
        this.attribute19 = attribute19 == null ? null : attribute19.trim();
    }

    public String getAttribute20() {
        return attribute20;
    }

    public void setAttribute20(String attribute20) {
        this.attribute20 = attribute20 == null ? null : attribute20.trim();
    }

    public String getAttribute21() {
        return attribute21;
    }

    public void setAttribute21(String attribute21) {
        this.attribute21 = attribute21 == null ? null : attribute21.trim();
    }

    public String getAttribute22() {
        return attribute22;
    }

    public void setAttribute22(String attribute22) {
        this.attribute22 = attribute22 == null ? null : attribute22.trim();
    }

    public String getAttribute23() {
        return attribute23;
    }

    public void setAttribute23(String attribute23) {
        this.attribute23 = attribute23 == null ? null : attribute23.trim();
    }

    public String getAttribute24() {
        return attribute24;
    }

    public void setAttribute24(String attribute24) {
        this.attribute24 = attribute24 == null ? null : attribute24.trim();
    }

    public String getAttribute25() {
        return attribute25;
    }

    public void setAttribute25(String attribute25) {
        this.attribute25 = attribute25 == null ? null : attribute25.trim();
    }

    public String getAttribute26() {
        return attribute26;
    }

    public void setAttribute26(String attribute26) {
        this.attribute26 = attribute26 == null ? null : attribute26.trim();
    }

    public String getAttribute27() {
        return attribute27;
    }

    public void setAttribute27(String attribute27) {
        this.attribute27 = attribute27 == null ? null : attribute27.trim();
    }

    public String getAttribute28() {
        return attribute28;
    }

    public void setAttribute28(String attribute28) {
        this.attribute28 = attribute28 == null ? null : attribute28.trim();
    }

    public String getAttribute29() {
        return attribute29;
    }

    public void setAttribute29(String attribute29) {
        this.attribute29 = attribute29 == null ? null : attribute29.trim();
    }

    public String getAttribute30() {
        return attribute30;
    }

    public void setAttribute30(String attribute30) {
        this.attribute30 = attribute30 == null ? null : attribute30.trim();
    }

    public String getAttribute31() {
        return attribute31;
    }

    public void setAttribute31(String attribute31) {
        this.attribute31 = attribute31 == null ? null : attribute31.trim();
    }

    public String getAttribute32() {
        return attribute32;
    }

    public void setAttribute32(String attribute32) {
        this.attribute32 = attribute32 == null ? null : attribute32.trim();
    }

    public String getAttribute33() {
        return attribute33;
    }

    public void setAttribute33(String attribute33) {
        this.attribute33 = attribute33 == null ? null : attribute33.trim();
    }

    public String getAttribute34() {
        return attribute34;
    }

    public void setAttribute34(String attribute34) {
        this.attribute34 = attribute34 == null ? null : attribute34.trim();
    }

    public String getAttribute35() {
        return attribute35;
    }

    public void setAttribute35(String attribute35) {
        this.attribute35 = attribute35 == null ? null : attribute35.trim();
    }

    public String getAttribute36() {
        return attribute36;
    }

    public void setAttribute36(String attribute36) {
        this.attribute36 = attribute36 == null ? null : attribute36.trim();
    }

    public String getAttribute37() {
        return attribute37;
    }

    public void setAttribute37(String attribute37) {
        this.attribute37 = attribute37 == null ? null : attribute37.trim();
    }

    public String getAttribute38() {
        return attribute38;
    }

    public void setAttribute38(String attribute38) {
        this.attribute38 = attribute38 == null ? null : attribute38.trim();
    }

    public String getAttribute39() {
        return attribute39;
    }

    public void setAttribute39(String attribute39) {
        this.attribute39 = attribute39 == null ? null : attribute39.trim();
    }

    public String getAttribute40() {
        return attribute40;
    }

    public void setAttribute40(String attribute40) {
        this.attribute40 = attribute40 == null ? null : attribute40.trim();
    }

    public String getAttribute41() {
        return attribute41;
    }

    public void setAttribute41(String attribute41) {
        this.attribute41 = attribute41 == null ? null : attribute41.trim();
    }

    public String getAttribute42() {
        return attribute42;
    }

    public void setAttribute42(String attribute42) {
        this.attribute42 = attribute42 == null ? null : attribute42.trim();
    }

    public String getAttribute43() {
        return attribute43;
    }

    public void setAttribute43(String attribute43) {
        this.attribute43 = attribute43 == null ? null : attribute43.trim();
    }

    public String getAttribute44() {
        return attribute44;
    }

    public void setAttribute44(String attribute44) {
        this.attribute44 = attribute44 == null ? null : attribute44.trim();
    }

    public String getAttribute45() {
        return attribute45;
    }

    public void setAttribute45(String attribute45) {
        this.attribute45 = attribute45 == null ? null : attribute45.trim();
    }

    public String getAttribute46() {
        return attribute46;
    }

    public void setAttribute46(String attribute46) {
        this.attribute46 = attribute46 == null ? null : attribute46.trim();
    }

    public String getAttribute47() {
        return attribute47;
    }

    public void setAttribute47(String attribute47) {
        this.attribute47 = attribute47 == null ? null : attribute47.trim();
    }

    public String getAttribute48() {
        return attribute48;
    }

    public void setAttribute48(String attribute48) {
        this.attribute48 = attribute48 == null ? null : attribute48.trim();
    }

    public String getAttribute49() {
        return attribute49;
    }

    public void setAttribute49(String attribute49) {
        this.attribute49 = attribute49 == null ? null : attribute49.trim();
    }

    public String getAttribute50() {
        return attribute50;
    }

    public void setAttribute50(String attribute50) {
        this.attribute50 = attribute50 == null ? null : attribute50.trim();
    }

    public Byte getWriteBackStatus() {
        return writeBackStatus;
    }

    public void setWriteBackStatus(Byte writeBackStatus) {
        this.writeBackStatus = writeBackStatus;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public Byte getFailReasonType() {
        return failReasonType;
    }

    public void setFailReasonType(Byte failReasonType) {
        this.failReasonType = failReasonType;
    }

    public Long getSupplierPoolId() {
        return supplierPoolId;
    }

    public void setSupplierPoolId(Long supplierPoolId) {
        this.supplierPoolId = supplierPoolId;
    }

    public Date getGmtCloseCancel() {
        return gmtCloseCancel;
    }

    public void setGmtCloseCancel(Date gmtCloseCancel) {
        this.gmtCloseCancel = gmtCloseCancel;
    }

    public Long getLastCancelId() {
        return lastCancelId;
    }

    public void setLastCancelId(Long lastCancelId) {
        this.lastCancelId = lastCancelId;
    }

    public BigDecimal getNotaxLocalAmount() {
        return notaxLocalAmount;
    }

    public void setNotaxLocalAmount(BigDecimal notaxLocalAmount) {
        this.notaxLocalAmount = notaxLocalAmount;
    }

    public BigDecimal getTaxLocalAmount() {
        return taxLocalAmount;
    }

    public void setTaxLocalAmount(BigDecimal taxLocalAmount) {
        this.taxLocalAmount = taxLocalAmount;
    }

    public BigDecimal getLocalTax() {
        return localTax;
    }

    public void setLocalTax(BigDecimal localTax) {
        this.localTax = localTax;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}