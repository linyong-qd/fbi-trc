package trc.repository.model;

import java.math.BigDecimal;

public class TqcQuotaAcctHis {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.PKID
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private String pkid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.MCHT_CODE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private String mchtCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.PRJ_CODE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private String prjCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.ACCT_NO
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private String acctNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DATE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private String txnDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_AMT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private BigDecimal txnDayAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_AMT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private BigDecimal txnMonthAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_CNT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private BigDecimal txnDayCnt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_CNT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private BigDecimal txnMonthCnt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT_HIS.REMARK
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.PKID
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.PKID
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getPkid() {
        return pkid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.PKID
     *
     * @param pkid the value for TRC.TQC_QUOTA_ACCT_HIS.PKID
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setPkid(String pkid) {
        this.pkid = pkid == null ? null : pkid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.MCHT_CODE
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.MCHT_CODE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getMchtCode() {
        return mchtCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.MCHT_CODE
     *
     * @param mchtCode the value for TRC.TQC_QUOTA_ACCT_HIS.MCHT_CODE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setMchtCode(String mchtCode) {
        this.mchtCode = mchtCode == null ? null : mchtCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.PRJ_CODE
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.PRJ_CODE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getPrjCode() {
        return prjCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.PRJ_CODE
     *
     * @param prjCode the value for TRC.TQC_QUOTA_ACCT_HIS.PRJ_CODE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode == null ? null : prjCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.ACCT_NO
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.ACCT_NO
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.ACCT_NO
     *
     * @param acctNo the value for TRC.TQC_QUOTA_ACCT_HIS.ACCT_NO
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DATE
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.TXN_DATE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getTxnDate() {
        return txnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DATE
     *
     * @param txnDate the value for TRC.TQC_QUOTA_ACCT_HIS.TXN_DATE
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate == null ? null : txnDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_AMT
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_AMT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public BigDecimal getTxnDayAmt() {
        return txnDayAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_AMT
     *
     * @param txnDayAmt the value for TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_AMT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setTxnDayAmt(BigDecimal txnDayAmt) {
        this.txnDayAmt = txnDayAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_AMT
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_AMT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public BigDecimal getTxnMonthAmt() {
        return txnMonthAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_AMT
     *
     * @param txnMonthAmt the value for TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_AMT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setTxnMonthAmt(BigDecimal txnMonthAmt) {
        this.txnMonthAmt = txnMonthAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_CNT
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_CNT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public BigDecimal getTxnDayCnt() {
        return txnDayCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_CNT
     *
     * @param txnDayCnt the value for TRC.TQC_QUOTA_ACCT_HIS.TXN_DAY_CNT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setTxnDayCnt(BigDecimal txnDayCnt) {
        this.txnDayCnt = txnDayCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_CNT
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_CNT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public BigDecimal getTxnMonthCnt() {
        return txnMonthCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_CNT
     *
     * @param txnMonthCnt the value for TRC.TQC_QUOTA_ACCT_HIS.TXN_MONTH_CNT
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setTxnMonthCnt(BigDecimal txnMonthCnt) {
        this.txnMonthCnt = txnMonthCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT_HIS.REMARK
     *
     * @return the value of TRC.TQC_QUOTA_ACCT_HIS.REMARK
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT_HIS.REMARK
     *
     * @param remark the value for TRC.TQC_QUOTA_ACCT_HIS.REMARK
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}