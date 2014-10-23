package trc.view;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.common.utils.MessageUtil;
import skyline.service.ToolsService;
import trc.common.enums.AcctType;
import trc.repository.model.TqcRuleAcct;
import trc.repository.model.TqcRuleAcctKey;
import trc.repository.model.TqcRuleMcht;
import trc.repository.model.TqcRuleMchtKey;
import trc.service.TqcRuleAcctService;
import trc.service.TqcRuleMchtService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Vincent on 14-10-15.
 */
@ManagedBean
@ViewScoped
public class TqcRuleAcctAction {

    private static final Logger logger = LoggerFactory.getLogger(TqcRuleAcctAction.class);

    private String acctCode;
    private String prjCode;
    private String acctType;

    private TqcRuleAcct tqcRuleAcct;
    @ManagedProperty(value = "#{tqcRuleAcctService}")
    private TqcRuleAcctService acctService;
    @ManagedProperty(value = "#{toolsService}")
    private ToolsService toolService;
    private List<TqcRuleAcct> ruleList = new ArrayList<TqcRuleAcct>();
    private TqcRuleAcct selectedRuleRecord;
    private String jscript;
    private List<SelectItem> acctTypeList;

    private AcctType acctTypeEnum = AcctType.MERCHANT;

    @PostConstruct
    public void init() {
        tqcRuleAcct = new TqcRuleAcct();
        acctTypeList = toolService.getEnuSelectItemList("ACCTTYPE",false,false);
        acctTypeList.add(0, new SelectItem("", ""));
        initRuleInfo();
    }

    public void initRuleInfo(){

        Map<String, String> paramsmap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String pkid = paramsmap.get("pkid");
        String action = paramsmap.get("action");
        logger.info("PKID: " + pkid + " ACTION:" + action);
        if (StringUtils.isNotEmpty(pkid) && StringUtils.isNotEmpty(action)) {
            if ("update".equalsIgnoreCase(action)) {
                String[] key = pkid.split(",");
                TqcRuleAcctKey pk = new TqcRuleAcctKey();
                pk.setMchtCode(key[0]);
                pk.setPrjCode(key[1]);
                pk.setAcctType(key[2]);
                tqcRuleAcct = acctService.qryRuleByKey(pk);
            }
        }
    }

    /**
     * 添加被扣单位规则
     */
    public String onInsert() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getSingleLim()) >= 0) {
                MessageUtil.addError("单笔限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getDayTotalLim()) >= 0) {
                MessageUtil.addError("日累计限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("月累计限额金额输入有误!");
                return null;
            }

            // 确认该规则是否已经存在
            if (acctService.isRuleExist(tqcRuleAcct.getMchtCode().trim(), tqcRuleAcct.getPrjCode().trim(),tqcRuleAcct.getAcctType().trim())) {
                MessageUtil.addError("该规则已存在!");
                return null;
            }
            acctService.insertRule(tqcRuleAcct);
            logger.info("被扣新增规则成功！被扣单位客户号："+tqcRuleAcct.getMchtCode()+"  项目编号："+tqcRuleAcct.getPrjCode());
            MessageUtil.addInfo("新规则添加操作成功。被扣客户号：" + tqcRuleAcct.getMchtCode());
            ruleList.add(tqcRuleAcct);
        } catch (Exception e) {
            logger.error("添加被扣单位规则操作失败。", e);
            MessageUtil.addError("新规则添加操作失败。" + e.getMessage());
        }
        return null;
    }

    /**
     * 查询被扣单位规则
     */
    public String onQuery() {
        try {
            ruleList = acctService.qryRuleByAcctCodePrjCodeAcctType(acctCode, prjCode,tqcRuleAcct.getAcctType());
            if (ruleList.size() == 0) {
                MessageUtil.addWarn("没有查询到数据记录。");
            }
        } catch (Exception e) {
            logger.error("查询被扣单位规则失败。", e);
            MessageUtil.addError("查询规则信息记录失败。");
        }
        return null;
    }

    /**
     * 更新行业领域规则
     */
    public String onUpdate() {
        try {

            if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getSingleLim()) >= 0) {
                MessageUtil.addError("单笔限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getDayTotalLim()) >= 0) {
                MessageUtil.addError("日累计限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("月累计限额金额输入有误!");
                return null;
            }
            acctService.updateRule(tqcRuleAcct);
            logger.info("更新被扣单位规则成功！被扣单位客户号："+tqcRuleAcct.getMchtCode()+"  项目编号："+tqcRuleAcct.getPrjCode());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("更新被扣单位规则信息失败。", e);
            MessageUtil.addError("更新被扣单位规则信息失败。" + e.getMessage());
        }
        return null;
    }

    /**
     * 删除被扣单位规则
     */
    public String onDelete() {
        try {
            if (selectedRuleRecord == null) {
                MessageUtil.addWarn("至少选择一笔记录！");
                return null;
            }
            acctService.deleteRule(selectedRuleRecord);
            ruleList.remove(selectedRuleRecord);
           // acctService.deleteRule(tqcRuleAcct);
            logger.info("删除被扣单位规则成功！被扣单位客户号："+selectedRuleRecord.getMchtCode()+"  项目编号："+selectedRuleRecord.getPrjCode());

        } catch (Exception e) {
            logger.error("删除被扣单位规则失败。", e);
            MessageUtil.addError("删除被扣单位规则失败。" + e.getMessage());
        }
        return null;
    }


    public String getAcctCode() {
        return acctCode;
    }

    public void setAcctCode(String acctCode) {
        this.acctCode = acctCode;
    }

    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode;
    }

    public TqcRuleAcctService getAcctService() {
        return acctService;
    }

    public void setAcctService(TqcRuleAcctService acctService) {
        this.acctService = acctService;
    }

    public List<TqcRuleAcct> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<TqcRuleAcct> ruleList) {
        this.ruleList = ruleList;
    }

    public TqcRuleAcct getSelectedRuleRecord() {
        return selectedRuleRecord;
    }

    public void setSelectedRuleRecord(TqcRuleAcct selectedRuleRecord) {
        this.selectedRuleRecord = selectedRuleRecord;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public TqcRuleAcct getTqcRuleAcct() {
        return tqcRuleAcct;
    }

    public void setTqcRuleAcct(TqcRuleAcct tqcRuleAcct) {
        this.tqcRuleAcct = tqcRuleAcct;
    }


    public String getJscript() {
        return jscript;
    }

    public void setJscript(String jscript) {
        this.jscript = jscript;
    }

    public ToolsService getToolService() {
        return toolService;
    }

    public void setToolService(ToolsService toolService) {
        this.toolService = toolService;
    }

    public List<SelectItem> getAcctTypeList() {
        return acctTypeList;
    }

    public void setAcctTypeList(List<SelectItem> acctTypeList) {
        this.acctTypeList = acctTypeList;
    }

    public AcctType getAcctTypeEnum() {
        return acctTypeEnum;
    }

    public void setAcctTypeEnum(AcctType acctTypeEnum) {
        this.acctTypeEnum = acctTypeEnum;
    }
}
