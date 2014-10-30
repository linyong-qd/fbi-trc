package trc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.platform.security.OperatorManager;
import skyline.service.ToolsService;
import trc.repository.dao.TqcRuleAcctMapper;
import trc.repository.dao.TqcRuleMchtMapper;
import trc.repository.model.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 14-10-15.
 */
@Service
public class TqcRuleAcctService {
    private static final Logger logger = LoggerFactory.getLogger(TqcRuleAcctService.class);
    @Autowired
    private TqcRuleAcctMapper tqcRuleAcctMapper;

    public List<TqcRuleAcct> qryRuleByAcctCodePrjCodeAcctType(String acctCode,String prjCode,String acctType){
        TqcRuleAcctExample example = new TqcRuleAcctExample();
        if(acctType==null||"".equals(acctType)){
            example.createCriteria().andPrjCodeEqualTo(prjCode).andMchtCodeEqualTo(acctCode);
        }else{
            example.createCriteria().andAcctTypeEqualTo(acctType).andPrjCodeEqualTo(prjCode).andMchtCodeEqualTo(acctCode);
        }

        return tqcRuleAcctMapper.selectByExample(example);
    }
    public boolean isRuleExist(String acctCode,String prjCode,String acctType) {
        return qryRuleByAcctCodePrjCodeAcctType(acctCode, prjCode,acctType).size() > 0;
    }
    @Transactional
    public int insertRule(TqcRuleAcct ruleAcct) {
        ruleAcct.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        ruleAcct.setOperId(om.getOperatorId());
        ruleAcct.setRecver(1);
        return tqcRuleAcctMapper.insert(ruleAcct);
    }

    @Transactional
    public int updateRule(TqcRuleAcct ruleAcct) {
       // TqcRuleAcct rule = getRuleByRule(ruleAcct);
        return tqcRuleAcctMapper.updateByPrimaryKey(ruleAcct);
    }

    @Transactional
    public int deleteRule(TqcRuleAcct ruleAcct) {
        //TqcRuleAcct rule = getRuleByRule(ruleAcct);
        TqcRuleAcctKey key = new TqcRuleAcctKey();
        key.setMchtCode(ruleAcct.getMchtCode());
        key.setPrjCode(ruleAcct.getPrjCode());
        key.setAcctType(ruleAcct.getAcctType());
        return tqcRuleAcctMapper.deleteByPrimaryKey(key);
    }

    public TqcRuleAcct qryRuleByKey(TqcRuleAcctKey key){
        return tqcRuleAcctMapper.selectByPrimaryKey(key);
    }

    private TqcRuleAcct getRuleByRule(TqcRuleAcct ruleAcct) {
        TqcRuleAcct rule = new TqcRuleAcct();
        rule.setPrjCode(ruleAcct.getPrjCode());
        rule.setMchtCode(ruleAcct.getMchtCode());
        rule.setMchtName(ruleAcct.getMchtName());
        rule.setSingleLim(ruleAcct.getSingleLim());
        rule.setDayAmtLim(ruleAcct.getDayAmtLim());
        rule.setMonthAmtLim(ruleAcct.getMonthAmtLim());
        rule.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        rule.setOperId(om.getOperatorId());
        return rule;
    }
}
