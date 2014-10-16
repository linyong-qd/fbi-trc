package trc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trc.repository.dao.TqcRuleMchtMapper;
import trc.repository.model.TqcRuleMcht;
import trc.repository.model.TqcRuleMchtExample;

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
        example.createCriteria().andMchtCodeEqualTo(mchtCode).andPrjCodeEqualTo(prjCode);
        return tqcRuleMchtMapper.selectByExample(example);
    }
    public boolean isRuleExist(String mchtCode,String prjCode) {
        return qryRuleByMchtCodePrjCode(mchtCode, prjCode).size() > 0;
    }
    public int insertRule(TqcRuleMcht ruleMcht) {
        return tqcRuleMchtMapper.insert(ruleMcht);
    }

}
