package trc.repository.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TqcRuleAreaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public TqcRuleAreaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
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
     * This method corresponds to the database table TRC.TQC_RULE_AREA
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
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
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
     * This class corresponds to the database table TRC.TQC_RULE_AREA
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

        public Criteria andAreaCodeIsNull() {
            addCriterion("AREA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("AREA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("AREA_CODE =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("AREA_CODE <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("AREA_CODE >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_CODE >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("AREA_CODE <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("AREA_CODE <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("AREA_CODE like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("AREA_CODE not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("AREA_CODE in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("AREA_CODE not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("AREA_CODE between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("AREA_CODE not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("AREA_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("AREA_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("AREA_NAME =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("AREA_NAME <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("AREA_NAME >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_NAME >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("AREA_NAME <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("AREA_NAME <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("AREA_NAME like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("AREA_NAME not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("AREA_NAME in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("AREA_NAME not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("AREA_NAME between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("AREA_NAME not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andSingleLimIsNull() {
            addCriterion("SINGLE_LIM is null");
            return (Criteria) this;
        }

        public Criteria andSingleLimIsNotNull() {
            addCriterion("SINGLE_LIM is not null");
            return (Criteria) this;
        }

        public Criteria andSingleLimEqualTo(BigDecimal value) {
            addCriterion("SINGLE_LIM =", value, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimNotEqualTo(BigDecimal value) {
            addCriterion("SINGLE_LIM <>", value, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimGreaterThan(BigDecimal value) {
            addCriterion("SINGLE_LIM >", value, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_LIM >=", value, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimLessThan(BigDecimal value) {
            addCriterion("SINGLE_LIM <", value, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_LIM <=", value, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimIn(List<BigDecimal> values) {
            addCriterion("SINGLE_LIM in", values, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimNotIn(List<BigDecimal> values) {
            addCriterion("SINGLE_LIM not in", values, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_LIM between", value1, value2, "singleLim");
            return (Criteria) this;
        }

        public Criteria andSingleLimNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_LIM not between", value1, value2, "singleLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimIsNull() {
            addCriterion("DAY_TOTAL_LIM is null");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimIsNotNull() {
            addCriterion("DAY_TOTAL_LIM is not null");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimEqualTo(BigDecimal value) {
            addCriterion("DAY_TOTAL_LIM =", value, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimNotEqualTo(BigDecimal value) {
            addCriterion("DAY_TOTAL_LIM <>", value, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimGreaterThan(BigDecimal value) {
            addCriterion("DAY_TOTAL_LIM >", value, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_TOTAL_LIM >=", value, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimLessThan(BigDecimal value) {
            addCriterion("DAY_TOTAL_LIM <", value, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_TOTAL_LIM <=", value, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimIn(List<BigDecimal> values) {
            addCriterion("DAY_TOTAL_LIM in", values, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimNotIn(List<BigDecimal> values) {
            addCriterion("DAY_TOTAL_LIM not in", values, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_TOTAL_LIM between", value1, value2, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andDayTotalLimNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_TOTAL_LIM not between", value1, value2, "dayTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimIsNull() {
            addCriterion("MONTH_TOTAL_LIM is null");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimIsNotNull() {
            addCriterion("MONTH_TOTAL_LIM is not null");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimEqualTo(BigDecimal value) {
            addCriterion("MONTH_TOTAL_LIM =", value, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimNotEqualTo(BigDecimal value) {
            addCriterion("MONTH_TOTAL_LIM <>", value, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimGreaterThan(BigDecimal value) {
            addCriterion("MONTH_TOTAL_LIM >", value, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_TOTAL_LIM >=", value, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimLessThan(BigDecimal value) {
            addCriterion("MONTH_TOTAL_LIM <", value, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_TOTAL_LIM <=", value, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimIn(List<BigDecimal> values) {
            addCriterion("MONTH_TOTAL_LIM in", values, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimNotIn(List<BigDecimal> values) {
            addCriterion("MONTH_TOTAL_LIM not in", values, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_TOTAL_LIM between", value1, value2, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLimNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_TOTAL_LIM not between", value1, value2, "monthTotalLim");
            return (Criteria) this;
        }

        public Criteria andRecverIsNull() {
            addCriterion("RECVER is null");
            return (Criteria) this;
        }

        public Criteria andRecverIsNotNull() {
            addCriterion("RECVER is not null");
            return (Criteria) this;
        }

        public Criteria andRecverEqualTo(BigDecimal value) {
            addCriterion("RECVER =", value, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverNotEqualTo(BigDecimal value) {
            addCriterion("RECVER <>", value, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverGreaterThan(BigDecimal value) {
            addCriterion("RECVER >", value, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECVER >=", value, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverLessThan(BigDecimal value) {
            addCriterion("RECVER <", value, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECVER <=", value, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverIn(List<BigDecimal> values) {
            addCriterion("RECVER in", values, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverNotIn(List<BigDecimal> values) {
            addCriterion("RECVER not in", values, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECVER between", value1, value2, "recver");
            return (Criteria) this;
        }

        public Criteria andRecverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECVER not between", value1, value2, "recver");
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

        public Criteria andOperIdIsNull() {
            addCriterion("OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(String value) {
            addCriterion("OPER_ID =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(String value) {
            addCriterion("OPER_ID <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(String value) {
            addCriterion("OPER_ID >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_ID >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(String value) {
            addCriterion("OPER_ID <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(String value) {
            addCriterion("OPER_ID <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLike(String value) {
            addCriterion("OPER_ID like", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotLike(String value) {
            addCriterion("OPER_ID not like", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<String> values) {
            addCriterion("OPER_ID in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<String> values) {
            addCriterion("OPER_ID not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(String value1, String value2) {
            addCriterion("OPER_ID between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(String value1, String value2) {
            addCriterion("OPER_ID not between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNull() {
            addCriterion("OPER_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNotNull() {
            addCriterion("OPER_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOperDateEqualTo(String value) {
            addCriterion("OPER_DATE =", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotEqualTo(String value) {
            addCriterion("OPER_DATE <>", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThan(String value) {
            addCriterion("OPER_DATE >", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_DATE >=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThan(String value) {
            addCriterion("OPER_DATE <", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThanOrEqualTo(String value) {
            addCriterion("OPER_DATE <=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLike(String value) {
            addCriterion("OPER_DATE like", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotLike(String value) {
            addCriterion("OPER_DATE not like", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateIn(List<String> values) {
            addCriterion("OPER_DATE in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotIn(List<String> values) {
            addCriterion("OPER_DATE not in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateBetween(String value1, String value2) {
            addCriterion("OPER_DATE between", value1, value2, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotBetween(String value1, String value2) {
            addCriterion("OPER_DATE not between", value1, value2, "operDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TRC.TQC_RULE_AREA
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
     * This class corresponds to the database table TRC.TQC_RULE_AREA
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