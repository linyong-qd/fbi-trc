package trc.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.common.utils.MessageUtil;
import trc.repository.model.TqcRuleMcht;
import trc.service.TqcRuleMchtService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 14-10-16.
 */
@ManagedBean
@ViewScoped
public class TqcRuleMchtAction {
    private static final Logger logger = LoggerFactory.getLogger(TqcRuleMchtAction.class);

    private TqcRuleMcht tqcRuleMcht;
    @ManagedProperty(value = "#{tqcRuleMchtService}")
    private  TqcRuleMchtService mchtService;
    private List<TqcRuleMcht> ruleList = new ArrayList<TqcRuleMcht>();

    @PostConstruct
    public void init() {
        tqcRuleMcht = new TqcRuleMcht();
    }


    public String onInsert() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getSingleLim()) >= 0) {
                MessageUtil.addError("单笔限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getDayTotalLim()) >= 0) {
                MessageUtil.addError("日累计限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("月累计限额金额输入有误!");
                return null;
            }

            // 确认该规则是否已经存在
            if (mchtService.isRuleExist(tqcRuleMcht.getMchtCode().trim(), tqcRuleMcht.getPrjCode())) {
                MessageUtil.addError("该规则已存在!");
                return null;
            }
            mchtService.insertRule(tqcRuleMcht);

            MessageUtil.addInfo("新规则添加操作成功。收款客户号：" + tqcRuleMcht.getMchtCode());
            ruleList.add(tqcRuleMcht);
        } catch (Exception e) {
            logger.error("新开卡操作失败。", e);
            MessageUtil.addError("新开卡操作失败。" + e.getMessage());
        }
        return null;
    }

    public TqcRuleMcht getTqcRuleMcht() {
        return tqcRuleMcht;
    }

    public void setTqcRuleMcht(TqcRuleMcht tqcRuleMcht) {
        this.tqcRuleMcht = tqcRuleMcht;
    }

    public TqcRuleMchtService getMchtService() {
        return mchtService;
    }

    public void setMchtService(TqcRuleMchtService mchtService) {
        this.mchtService = mchtService;
    }

    public List<TqcRuleMcht> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<TqcRuleMcht> ruleList) {
        this.ruleList = ruleList;
    }
}
