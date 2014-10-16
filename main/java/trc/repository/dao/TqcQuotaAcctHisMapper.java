package trc.repository.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import trc.repository.model.TqcQuotaAcctHis;
import trc.repository.model.TqcQuotaAcctHisExample;

public interface TqcQuotaAcctHisMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int countByExample(TqcQuotaAcctHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int deleteByExample(TqcQuotaAcctHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int deleteByPrimaryKey(String pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int insert(TqcQuotaAcctHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int insertSelective(TqcQuotaAcctHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    List<TqcQuotaAcctHis> selectByExample(TqcQuotaAcctHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    TqcQuotaAcctHis selectByPrimaryKey(String pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByExampleSelective(@Param("record") TqcQuotaAcctHis record, @Param("example") TqcQuotaAcctHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByExample(@Param("record") TqcQuotaAcctHis record, @Param("example") TqcQuotaAcctHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByPrimaryKeySelective(TqcQuotaAcctHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_QUOTA_ACCT_HIS
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByPrimaryKey(TqcQuotaAcctHis record);
}