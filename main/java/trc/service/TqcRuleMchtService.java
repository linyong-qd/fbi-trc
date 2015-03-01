package trc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.platform.security.OperatorManager;
import skyline.service.ToolsService;
import trc.repository.dao.TqcRuleMchtMapper;
import trc.repository.model.TqcRuleMcht;
import trc.repository.model.TqcRuleMchtExample;
import trc.repository.model.TqcRuleMchtKey;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 14-10-15.
 */
@Service
public class TqcRuleMchtService {
    private static final Logger logger = LoggerFactory.getLogger(TqcRuleMchtService.class);
    @Autowired
    private TqcRuleMchtMapper tqcRuleMchtMapper;

    public List<TqcRuleMcht> qryRuleByMchtCodePrjCode(String mchtCode,String prjCode){
        TqcRuleMchtExample example = new TqcRuleMchtExample();
        TqcRuleMchtExample.Criteria criteria=example.createCriteria();
        if(mchtCode!=null&&!"".equals(mchtCode)){
            criteria.andMchtCodeEqualTo(mchtCode);
        }
        if(prjCode!=null&&!"".equals(prjCode)){
            criteria.andPrjCodeEqualTo(prjCode);
        }

       // example.createCriteria().andMchtCodeEqualTo(mchtCode).andPrjCodeEqualTo(prjCode);

        return tqcRuleMchtMapper.selectByExample(example);
    }
    public boolean isRuleExist(String mchtCode,String prjCode) {
        return qryRuleByMchtCodePrjCode(mchtCode, prjCode).size() > 0;
    }
    @Transactional
    public int insertRule(TqcRuleMcht ruleMcht) {
        ruleMcht.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        ruleMcht.setOperId(om.getOperatorId());
        ruleMcht.setRecver(1);
        return tqcRuleMchtMapper.insert(ruleMcht);
    }

    @Transactional
    public int updateRule(TqcRuleMcht ruleMcht) {
        ruleMcht.setOperDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        OperatorManager om = ToolsService.getOperatorManager();
        ruleMcht.setOperId(om.getOperatorId());
        return tqcRuleMchtMapper.updateByPrimaryKey(ruleMcht);
    }
    @Transactional
    public int deleteRule(TqcRuleMcht ruleMcht) {
        TqcRuleMchtKey key = new TqcRuleMchtKey();
        key.setMchtCode(ruleMcht.getMchtCode());
        key.setPrjCode(ruleMcht.getPrjCode());
        return tqcRuleMchtMapper.deleteByPrimaryKey(key);
    }

    public TqcRuleMcht qryRuleByKey(TqcRuleMchtKey key){
        return tqcRuleMchtMapper.selectByPrimaryKey(key);
    }

    /**
     * 页面初始化查询全部内容
     */
    /*
    public List<TqcRuleMcht> getAllTqcRuleMcht(){
        TqcRuleMchtExample example = new TqcRuleMchtExample();
        example.createCriteria();
        return tqcRuleMchtMapper.selectByExample(example);
    }*/
}
