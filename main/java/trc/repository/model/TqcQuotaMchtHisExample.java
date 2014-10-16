package trc.repository.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TqcQuotaMchtHisExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public TqcQuotaMchtHisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPkidIsNull() {
            addCriterion("PKID is null");
            return (Criteria) this;
        }

        public Criteria andPkidIsNotNull() {
            addCriterion("PKID is not null");
            return (Criteria) this;
        }

        public Criteria andPkidEqualTo(String value) {
            addCriterion("PKID =", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotEqualTo(String value) {
            addCriterion("PKID <>", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidGreaterThan(String value) {
            addCriterion("PKID >", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidGreaterThanOrEqualTo(String value) {
            addCriterion("PKID >=", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidLessThan(String value) {
            addCriterion("PKID <", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidLessThanOrEqualTo(String value) {
            addCriterion("PKID <=", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidLike(String value) {
            addCriterion("PKID like", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotLike(String value) {
            addCriterion("PKID not like", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidIn(List<String> values) {
            addCriterion("PKID in", values, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotIn(List<String> values) {
            addCriterion("PKID not in", values, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidBetween(String value1, String value2) {
            addCriterion("PKID between", value1, value2, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotBetween(String value1, String value2) {
            addCriterion("PKID not between", value1, value2, "pkid");
            return (Criteria) this;
        }

        public Criteria andMchtCodeIsNull() {
            addCriterion("MCHT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMchtCodeIsNotNull() {
            addCriterion("MCHT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMchtCodeEqualTo(String value) {
            addCriterion("MCHT_CODE =", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeNotEqualTo(String value) {
            addCriterion("MCHT_CODE <>", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeGreaterThan(String value) {
            addCriterion("MCHT_CODE >", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MCHT_CODE >=", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeLessThan(String value) {
            addCriterion("MCHT_CODE <", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeLessThanOrEqualTo(String value) {
            addCriterion("MCHT_CODE <=", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeLike(String value) {
            addCriterion("MCHT_CODE like", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeNotLike(String value) {
            addCriterion("MCHT_CODE not like", value, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeIn(List<String> values) {
            addCriterion("MCHT_CODE in", values, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeNotIn(List<String> values) {
            addCriterion("MCHT_CODE not in", values, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeBetween(String value1, String value2) {
            addCriterion("MCHT_CODE between", value1, value2, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andMchtCodeNotBetween(String value1, String value2) {
            addCriterion("MCHT_CODE not between", value1, value2, "mchtCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIsNull() {
            addCriterion("PRJ_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIsNotNull() {
            addCriterion("PRJ_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPrjCodeEqualTo(String value) {
            addCriterion("PRJ_CODE =", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotEqualTo(String value) {
            addCriterion("PRJ_CODE <>", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeGreaterThan(String value) {
            addCriterion("PRJ_CODE >", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRJ_CODE >=", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLessThan(String value) {
            addCriterion("PRJ_CODE <", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLessThanOrEqualTo(String value) {
            addCriterion("PRJ_CODE <=", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeLike(String value) {
            addCriterion("PRJ_CODE like", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotLike(String value) {
            addCriterion("PRJ_CODE not like", value, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeIn(List<String> values) {
            addCriterion("PRJ_CODE in", values, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotIn(List<String> values) {
            addCriterion("PRJ_CODE not in", values, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeBetween(String value1, String value2) {
            addCriterion("PRJ_CODE between", value1, value2, "prjCode");
            return (Criteria) this;
        }

        public Criteria andPrjCodeNotBetween(String value1, String value2) {
            addCriterion("PRJ_CODE not between", value1, value2, "prjCode");
            return (Criteria) this;
        }

        public Criteria andTxnDateIsNull() {
            addCriterion("TXN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTxnDateIsNotNull() {
            addCriterion("TXN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTxnDateEqualTo(String value) {
            addCriterion("TXN_DATE =", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateNotEqualTo(String value) {
            addCriterion("TXN_DATE <>", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateGreaterThan(String value) {
            addCriterion("TXN_DATE >", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateGreaterThanOrEqualTo(String value) {
            addCriterion("TXN_DATE >=", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateLessThan(String value) {
            addCriterion("TXN_DATE <", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateLessThanOrEqualTo(String value) {
            addCriterion("TXN_DATE <=", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateLike(String value) {
            addCriterion("TXN_DATE like", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateNotLike(String value) {
            addCriterion("TXN_DATE not like", value, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateIn(List<String> values) {
            addCriterion("TXN_DATE in", values, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateNotIn(List<String> values) {
            addCriterion("TXN_DATE not in", values, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateBetween(String value1, String value2) {
            addCriterion("TXN_DATE between", value1, value2, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDateNotBetween(String value1, String value2) {
            addCriterion("TXN_DATE not between", value1, value2, "txnDate");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtIsNull() {
            addCriterion("TXN_DAY_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtIsNotNull() {
            addCriterion("TXN_DAY_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_AMT =", value, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtNotEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_AMT <>", value, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtGreaterThan(BigDecimal value) {
            addCriterion("TXN_DAY_AMT >", value, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_AMT >=", value, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtLessThan(BigDecimal value) {
            addCriterion("TXN_DAY_AMT <", value, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_AMT <=", value, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtIn(List<BigDecimal> values) {
            addCriterion("TXN_DAY_AMT in", values, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtNotIn(List<BigDecimal> values) {
            addCriterion("TXN_DAY_AMT not in", values, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_DAY_AMT between", value1, value2, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_DAY_AMT not between", value1, value2, "txnDayAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtIsNull() {
            addCriterion("TXN_MONTH_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtIsNotNull() {
            addCriterion("TXN_MONTH_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_AMT =", value, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtNotEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_AMT <>", value, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtGreaterThan(BigDecimal value) {
            addCriterion("TXN_MONTH_AMT >", value, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_AMT >=", value, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtLessThan(BigDecimal value) {
            addCriterion("TXN_MONTH_AMT <", value, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_AMT <=", value, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtIn(List<BigDecimal> values) {
            addCriterion("TXN_MONTH_AMT in", values, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtNotIn(List<BigDecimal> values) {
            addCriterion("TXN_MONTH_AMT not in", values, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_MONTH_AMT between", value1, value2, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_MONTH_AMT not between", value1, value2, "txnMonthAmt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntIsNull() {
            addCriterion("TXN_DAY_CNT is null");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntIsNotNull() {
            addCriterion("TXN_DAY_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_CNT =", value, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntNotEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_CNT <>", value, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntGreaterThan(BigDecimal value) {
            addCriterion("TXN_DAY_CNT >", value, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_CNT >=", value, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntLessThan(BigDecimal value) {
            addCriterion("TXN_DAY_CNT <", value, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_DAY_CNT <=", value, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntIn(List<BigDecimal> values) {
            addCriterion("TXN_DAY_CNT in", values, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntNotIn(List<BigDecimal> values) {
            addCriterion("TXN_DAY_CNT not in", values, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_DAY_CNT between", value1, value2, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnDayCntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_DAY_CNT not between", value1, value2, "txnDayCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntIsNull() {
            addCriterion("TXN_MONTH_CNT is null");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntIsNotNull() {
            addCriterion("TXN_MONTH_CNT is not null");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_CNT =", value, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntNotEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_CNT <>", value, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntGreaterThan(BigDecimal value) {
            addCriterion("TXN_MONTH_CNT >", value, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_CNT >=", value, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntLessThan(BigDecimal value) {
            addCriterion("TXN_MONTH_CNT <", value, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TXN_MONTH_CNT <=", value, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntIn(List<BigDecimal> values) {
            addCriterion("TXN_MONTH_CNT in", values, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntNotIn(List<BigDecimal> values) {
            addCriterion("TXN_MONTH_CNT not in", values, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_MONTH_CNT between", value1, value2, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andTxnMonthCntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TXN_MONTH_CNT not between", value1, value2, "txnMonthCnt");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAcctNoIsNull() {
            addCriterion("ACCT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAcctNoIsNotNull() {
            addCriterion("ACCT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAcctNoEqualTo(String value) {
            addCriterion("ACCT_NO =", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotEqualTo(String value) {
            addCriterion("ACCT_NO <>", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoGreaterThan(String value) {
            addCriterion("ACCT_NO >", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_NO >=", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoLessThan(String value) {
            addCriterion("ACCT_NO <", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoLessThanOrEqualTo(String value) {
            addCriterion("ACCT_NO <=", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoLike(String value) {
            addCriterion("ACCT_NO like", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotLike(String value) {
            addCriterion("ACCT_NO not like", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoIn(List<String> values) {
            addCriterion("ACCT_NO in", values, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotIn(List<String> values) {
            addCriterion("ACCT_NO not in", values, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoBetween(String value1, String value2) {
            addCriterion("ACCT_NO between", value1, value2, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotBetween(String value1, String value2) {
            addCriterion("ACCT_NO not between", value1, value2, "acctNo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated do_not_delete_during_merge Wed Oct 15 16:40:20 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRC.TQC_QUOTA_MCHT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}