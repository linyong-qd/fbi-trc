package trc.repository.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import trc.repository.model.TqcRuleArea;
import trc.repository.model.TqcRuleAreaExample;

public interface TqcRuleAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int countByExample(TqcRuleAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int deleteByExample(TqcRuleAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int deleteByPrimaryKey(String areaCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int insert(TqcRuleArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int insertSelective(TqcRuleArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    List<TqcRuleArea> selectByExample(TqcRuleAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    TqcRuleArea selectByPrimaryKey(String areaCode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByExampleSelective(@Param("record") TqcRuleArea record, @Param("example") TqcRuleAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByExample(@Param("record") TqcRuleArea record, @Param("example") TqcRuleAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByPrimaryKeySelective(TqcRuleArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRC.TQC_RULE_AREA
     *
     * @mbggenerated Wed Oct 15 16:40:20 CST 2014
     */
    int updateByPrimaryKey(TqcRuleArea record);
}