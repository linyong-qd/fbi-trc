package trc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trc.repository.dao.TqcRuleAcctMapper;
import trc.repository.model.TqcRuleAcct;

/**
 * Created by Vincent on 14-10-15.
 */
@Service
public class TqcRuleAcctService {
    private static final Logger logger = LoggerFactory.getLogger(TqcRuleAcctService.class);

    @Autowired
    private TqcRuleAcctMapper tqcRuleAcctMapper;

    @Transactional
    public int insertRule(TqcRuleAcct ruleAcct){
        return tqcRuleAcctMapper.insert(ruleAcct);
    }
}
