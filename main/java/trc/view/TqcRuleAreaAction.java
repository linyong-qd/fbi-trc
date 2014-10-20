package trc.view;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.common.utils.MessageUtil;
import trc.repository.model.TqcRuleArea;
import trc.repository.model.TqcRuleMcht;
//import trc.repository.model.TqcRuleAreaKey;
import trc.service.TqcRuleAreaService;
import trc.service.TqcRuleMchtService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Vincent on 14-10-18.
 */
@ManagedBean
@ViewScoped
public class TqcRuleAreaAction {
    private static final Logger logger = LoggerFactory.getLogger(TqcRuleAreaAction.class);

    private String areaCode;
    //private String prjCode;
    private TqcRuleArea tqcRuleArea;
    @ManagedProperty(value = "#{tqcRuleAreaService}")
    private TqcRuleAreaService areaService;
    private List<TqcRuleArea> ruleList = new ArrayList<TqcRuleArea>();
    private TqcRuleArea[] selectedRuleRecords;
    private String jscript;

    @PostConstruct
    public void init() {
        tqcRuleArea = new TqcRuleArea();
        initRuleInfo();
    }

    public void initRuleInfo(){

        Map<String, String> paramsmap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String pkid = paramsmap.get("pkid");
        String action = paramsmap.get("action");
        logger.info("PKID: " + pkid + " ACTION:" + action);
        if (!StringUtils.isEmpty(pkid) && !StringUtils.isEmpty(action)) {
            if ("update".equalsIgnoreCase(action)) {
               /* String[] key = pkid.split(",");
                TqcRuleAreaKey pk = new TqcRuleAreaKey();
                pk.setMchtCode(key[0]);
                pk.setPrjCode(key[1]);*/
                tqcRuleArea = areaService.qryRuleByKey(pkid);
            }
        }
    }


    public String onInsert() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getSingleLim()) >= 0) {
                MessageUtil.addError("单笔限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getDayTotalLim()) >= 0) {
                MessageUtil.addError("日累计限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("月累计限额金额输入有误!");
                return null;
            }

            // 确认该规则是否已经存在
            if (areaService.isRuleExist(tqcRuleArea.getAreaCode().trim())) {
                MessageUtil.addError("该规则已存在!");
                return null;
            }
            areaService.insertRule(tqcRuleArea);
            logger.info("行业领域新增规则成功！行业领域编号："+tqcRuleArea.getAreaCode()+"  行业领域名称："+tqcRuleArea.getAreaName());
            MessageUtil.addInfo("新规则添加操作成功。行业领域编号："+tqcRuleArea.getAreaCode());
            ruleList.add(tqcRuleArea);
        } catch (Exception e) {
            logger.error("行业领域新增规则操作失败。", e);
            MessageUtil.addError("行业领域新增规则操作失败。" + e.getMessage());
        }
        return null;
    }

    public String onQuery() {
        try {

            ruleList = areaService.qryRuleByAreaCode(areaCode);
            if (ruleList.size() == 0) {
                MessageUtil.addWarn("没有查询到数据记录。");
            }
        } catch (Exception e) {
            logger.error("查询行业领域规则失败。", e);
            MessageUtil.addError("查询规则信息记录失败。");
        }
        return null;
    }

    public String onUpdate() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getSingleLim()) >= 0) {
                MessageUtil.addError("单笔限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getDayTotalLim()) >= 0) {
                MessageUtil.addError("日累计限额金额输入有误!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("月累计限额金额输入有误!");
                return null;
            }
            areaService.updateRule(tqcRuleArea);
            logger.info("行业领域更新规则成功！行业领域编号："+tqcRuleArea.getAreaCode()+"  行业领域名称："+tqcRuleArea.getAreaName());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("行业领域更新规则失败。", e);
            MessageUtil.addError("行业领域更新规则失败。" + e.getMessage());
        }
        return null;
    }

    public String onDelete() {
        try {
            if (selectedRuleRecords == null || selectedRuleRecords.length == 0) {
                MessageUtil.addWarn("至少选择一笔记录！");
                return null;
            }
            areaService.deleteRule(tqcRuleArea);
            logger.info("行业领域删除规则成功！行业领域编号："+tqcRuleArea.getAreaCode()+"  行业领域名称："+tqcRuleArea.getAreaName());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("删除行业领域规则信息失败。", e);
            MessageUtil.addError("删除行业领域规则信息失败。" + e.getMessage());
        }
        return null;
    }

    public TqcRuleArea getTqcRuleArea() {
        return tqcRuleArea;
    }

    public void setTqcRuleArea(TqcRuleArea tqcRuleArea) {
        this.tqcRuleArea = tqcRuleArea;
    }

    public TqcRuleAreaService getAreaService() {
        return areaService;
    }

    public void setAreaService(TqcRuleAreaService areaService) {
        this.areaService = areaService;
    }

    public List<TqcRuleArea> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<TqcRuleArea> ruleList) {
        this.ruleList = ruleList;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }


    public TqcRuleArea[] getSelectedRuleRecords() {
        return selectedRuleRecords;
    }

    public void setSelectedRuleRecords(TqcRuleArea[] selectedRuleRecords) {
        this.selectedRuleRecords = selectedRuleRecords;
    }

    public String getJscript() {
        return jscript;
    }

    public void setJscript(String jscript) {
        this.jscript = jscript;
    }
}
