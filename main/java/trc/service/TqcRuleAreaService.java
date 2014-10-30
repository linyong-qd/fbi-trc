package trc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.platform.security.OperatorManager;
import skyline.service.ToolsService;
import trc.repository.dao.TqcRuleAreaMapper;
import trc.repository.model.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 14-10-15.
 */
@Service
public class TqcRuleAreaService {
    private static final Logger logger = LoggerFactory.getLogger(TqcRuleAreaService.class);
    @Autowired
    private TqcRuleAreaMapper tqcRuleAreaMapper;

    public List<TqcRuleArea> qryRuleByAreaCode(String areaCode){
        TqcRuleAreaExample example = new TqcRuleAreaExample();
        example.createCriteria().andAreaCodeEqualTo(areaCode);//.andPrjCodeEqualTo(prjCode);
        return tqcRuleAreaMapper.selectByExample(example);
    }
    public boolean isRuleExist(String areaCode) {
        return qryRuleByAreaCode(areaCode).size() > 0;
    }
    @Transactional
    public int insertRule(TqcRuleArea ruleArea) {
        ruleArea.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        ruleArea.setOperId(om.getOperatorId());
        ruleArea.setRecver(1);
        return tqcRuleAreaMapper.insert(ruleArea);
    }

    @Transactional
    public int updateRule(TqcRuleArea ruleArea) {
        //TqcRuleArea rule = getRuleByRule(ruleArea);
        return tqcRuleAreaMapper.updateByPrimaryKey(ruleArea);
    }

    @Transactional
    public int deleteRule(TqcRuleArea ruleArea) {
        //TqcRuleArea rule = getRuleByRule(ruleArea);
        return tqcRuleAreaMapper.deleteByPrimaryKey(ruleArea.getAreaCode());
    }

    public TqcRuleArea qryRuleByKey(String areaCode){
        return tqcRuleAreaMapper.selectByPrimaryKey(areaCode);
    }

    private TqcRuleArea getRuleByRule(TqcRuleArea ruleArea) {
        TqcRuleArea rule = new TqcRuleArea();
        rule.setAreaCode(ruleArea.getAreaCode());
        rule.setAreaName(ruleArea.getAreaName());
        rule.setSingleLim(ruleArea.getSingleLim());
        rule.setDayAmtLim(ruleArea.getDayAmtLim());
        rule.setMonthAmtLim(ruleArea.getMonthAmtLim());
        rule.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        rule.setOperId(om.getOperatorId());
        return rule;
    }


}
