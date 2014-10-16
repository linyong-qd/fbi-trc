package skyline.repository.dao;

import skyline.repository.model.Ptmenu;
import skyline.repository.model.PtmenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface PtmenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTMENU
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int countByExample(PtmenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTMENU
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int deleteByExample(PtmenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTMENU
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int insert(Ptmenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTMENU
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int insertSelective(Ptmenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTMENU
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    List<Ptmenu> selectByExample(PtmenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTMENU
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByExampleSelective(@Param("record") Ptmenu record, @Param("example") PtmenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTMENU
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByExample(@Param("record") Ptmenu record, @Param("example") PtmenuExample example);
}