package trc.repository.model;

public class TqcQuotaAcctKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT.ACCT_NO
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    private String acctNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT.MCHT_CODE
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    private String mchtCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TRC.TQC_QUOTA_ACCT.PRJ_CODE
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    private String prjCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT.ACCT_NO
     *
     * @return the value of TRC.TQC_QUOTA_ACCT.ACCT_NO
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT.ACCT_NO
     *
     * @param acctNo the value for TRC.TQC_QUOTA_ACCT.ACCT_NO
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT.MCHT_CODE
     *
     * @return the value of TRC.TQC_QUOTA_ACCT.MCHT_CODE
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    public String getMchtCode() {
        return mchtCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT.MCHT_CODE
     *
     * @param mchtCode the value for TRC.TQC_QUOTA_ACCT.MCHT_CODE
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    public void setMchtCode(String mchtCode) {
        this.mchtCode = mchtCode == null ? null : mchtCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRC.TQC_QUOTA_ACCT.PRJ_CODE
     *
     * @return the value of TRC.TQC_QUOTA_ACCT.PRJ_CODE
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    public String getPrjCode() {
        return prjCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRC.TQC_QUOTA_ACCT.PRJ_CODE
     *
     * @param prjCode the value for TRC.TQC_QUOTA_ACCT.PRJ_CODE
     *
     * @mbggenerated Fri Oct 24 10:02:58 CST 2014
     */
    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode == null ? null : prjCode.trim();
    }
}