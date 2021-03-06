package trc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.platform.security.OperatorManager;
import skyline.service.ToolsService;

import trc.repository.dao.TqcRulePubMapper;
import trc.repository.model.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 14-10-15.
 */
@Service
public class TqcRulePubService {
    private static final Logger logger = LoggerFactory.getLogger(TqcRulePubService.class);

    @Autowired
    private TqcRulePubMapper tqcRulePubMapper;

    public List<TqcRulePub> qryRuleByRuleType(String ruleType){
        TqcRulePubExample example = new TqcRulePubExample();
       TqcRulePubExample.Criteria criteria= example.createCriteria();
        if(ruleType!=null&&!"".equals(ruleType)){
            criteria .andRuleTypeEqualTo(ruleType);
        }

        return tqcRulePubMapper.selectByExample(example);
    }

    public boolean isRuleExist(String ruleType) {
        return qryRuleByRuleType(ruleType).size() > 0;
    }

    @Transactional
    public int insertRule(TqcRulePub rulePub) {
        rulePub.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        rulePub.setOperId(om.getOperatorId());
        rulePub.setRecver(1);
        return tqcRulePubMapper.insert(rulePub);
    }

    @Transactional
    public int updateRule(TqcRulePub rulePub) {
        //TqcRulePub rule = getRuleByRule(rulePub);
        return tqcRulePubMapper.updateByPrimaryKey(rulePub);
    }

    @Transactional
    public int deleteRule(TqcRulePub rulePub) {
        //TqcRulePub rule = getRuleByRule(rulePub);
        return tqcRulePubMapper.deleteByPrimaryKey(rulePub.getRuleType());
    }

    public TqcRulePub qryRuleByKey(String ruleType){
        return tqcRulePubMapper.selectByPrimaryKey(ruleType);
    }

    private TqcRulePub getRuleByRule(TqcRulePub rulePub) {
        TqcRulePub rule = new TqcRulePub();
        rule.setRuleType(rulePub.getRuleType());
        rule.setSingleLim(rulePub.getSingleLim());
        rule.setDayAmtLim(rulePub.getDayAmtLim());
        rule.setMonthAmtLim(rulePub.getMonthAmtLim());
        rule.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        rule.setOperId(om.getOperatorId());
        return rule;
    }

    /**
     * 页面初始化时显示的全部内容
     */
    /*
    public List<TqcRulePub> getAllTqcRulePub(){
        TqcRulePubExample example = new TqcRulePubExample();
        example.createCriteria();
        return tqcRulePubMapper.selectByExample(example);
    }*/

}
