package trc.view;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.common.utils.MessageUtil;
import skyline.service.ToolsService;
import trc.common.enums.AcctType;
import trc.common.enums.RuleType;
import trc.repository.model.TqcRuleMcht;
import trc.repository.model.TqcRuleMchtKey;
import trc.repository.model.TqcRulePub;
import trc.service.TqcRuleMchtService;
import trc.service.TqcRulePubService;

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
 * Created by Vincent on 14-10-16.
 */
@ManagedBean
@ViewScoped
public class TqcRulePubAction {
    private static final Logger logger = LoggerFactory.getLogger(TqcRulePubAction.class);

    private String ruleType;
    private String del_inputHidden;
    private String msgsFlag;

    private TqcRulePub tqcRulePub;
    @ManagedProperty(value = "#{tqcRulePubService}")
    private TqcRulePubService pubService;
    private List<TqcRulePub> ruleList = new ArrayList<TqcRulePub>();
    private TqcRulePub selectedRuleRecord;
    @ManagedProperty(value = "#{toolsService}")
    private ToolsService toolService;
    private List<SelectItem> ruleTypeList;
    private String jscript;
    //������������
    private RuleType ruleTypeEnum = RuleType.MERCHANT;
    @PostConstruct
    public void init() {
        tqcRulePub = new TqcRulePub();
        ruleTypeList = toolService.getEnuSelectItemList("RULETYPE",false,false);
        ruleTypeList.add(0, new SelectItem("", ""));
        initRuleInfo();
    }

    public void initRuleInfo(){

        Map<String, String> paramsmap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String pkid = paramsmap.get("pkid");
        String action = paramsmap.get("action");
        logger.info("PKID: " + pkid + " ACTION:" + action);
        if (StringUtils.isNotEmpty(pkid) && StringUtils.isNotEmpty(action)) {

            if ("update".equalsIgnoreCase(action)) {
              /*  String[] key = pkid.split(",");
                TqcRuleMchtKey pk = new TqcRuleMchtKey();
                pk.setMchtCode(key[0]);
                pk.setPrjCode(key[1]);*/

                tqcRulePub = pubService.qryRuleByKey(pkid);
            }
        }
    }

    /**
     * ��ӹ�������
     */
    public String onInsert() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getSingleLim()) >= 0) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getDayAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getMonthAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            // ȷ�ϸù����Ƿ��Ѿ�����
            if (pubService.isRuleExist(tqcRulePub.getRuleType().trim())) {
                MessageUtil.addError("�ù����Ѵ���!");
                return null;
            }
            pubService.insertRule(tqcRulePub);
            logger.info("����������������ɹ����������ͣ�"+tqcRulePub.getRuleType()+"  ���ʽ�"+tqcRulePub.getSingleLim()+" ���ۼ��޶�:"+tqcRulePub.getDayAmtLim()+" ���ۼ��޶�:"+tqcRulePub.getMonthAmtLim());
            MessageUtil.addInfo("����������������ɹ���");
            ruleList.add(tqcRulePub);
        } catch (Exception e) {
            logger.error("���������������ʧ�ܡ�", e);
            MessageUtil.addError("�¹�����Ӳ���ʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    /**
     * ��ѯ��������
     */
    public String onQuery() {
        try {
            ruleList = pubService.qryRuleByRuleType(tqcRulePub.getRuleType());
            if (ruleList.size() == 0&&!"delete".equals(msgsFlag)) {
                MessageUtil.addWarn("û�в�ѯ�����ݼ�¼��");
            }
        } catch (Exception e) {
            logger.error("��ѯ��������ʧ�ܡ�", e);
            MessageUtil.addError("��ѯ������Ϣ��¼ʧ�ܡ�");
        }
        return null;
    }

    /**
     * ���¹�������
     */
    public String onUpdate() {
        try {

            if (new BigDecimal(0.00).compareTo(tqcRulePub.getSingleLim()) >= 0) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getDayAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getMonthAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            pubService.updateRule(tqcRulePub);
            logger.info("����������¹���ɹ����������ͣ�"+tqcRulePub.getRuleType()+"  ���ʽ�"+tqcRulePub.getSingleLim()+" ���ۼ��޶�:"+tqcRulePub.getDayAmtLim()+" ���ۼ��޶�:"+tqcRulePub.getMonthAmtLim());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("���¹���������Ϣʧ�ܡ�", e);
            MessageUtil.addError("���¹�����Ϣʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    /**
     * ɾ����������
     */
    public String onDelete() {
        try {
//            if (selectedRuleRecord == null) {
//                MessageUtil.addWarn("����ѡ��һ�ʼ�¼��");
//                return null;
//            }

            tqcRulePub = pubService.qryRuleByKey(del_inputHidden);
            pubService.deleteRule(tqcRulePub);
            ruleList.remove(tqcRulePub);
            logger.info("��������ɾ������ɹ����������ͣ�"+tqcRulePub.getRuleType()+"  ���ʽ�"+tqcRulePub.getSingleLim()+" ���ۼ��޶�:"+tqcRulePub.getDayAmtLim()+" ���ۼ��޶�:"+tqcRulePub.getMonthAmtLim());
            //jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("ɾ������������Ϣʧ�ܡ�", e);
            MessageUtil.addError("ɾ������������Ϣʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public TqcRulePub getTqcRulePub() {
        return tqcRulePub;
    }

    public void setTqcRulePub(TqcRulePub tqcRulePub) {
        this.tqcRulePub = tqcRulePub;
    }

    public TqcRulePubService getPubService() {
        return pubService;
    }

    public void setPubService(TqcRulePubService pubService) {
        this.pubService = pubService;
    }

    public List<TqcRulePub> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<TqcRulePub> ruleList) {
        this.ruleList = ruleList;
    }

    public TqcRulePub getSelectedRuleRecord() {
        return selectedRuleRecord;
    }

    public void setSelectedRuleRecord(TqcRulePub selectedRuleRecord) {
        this.selectedRuleRecord = selectedRuleRecord;
    }

    public ToolsService getToolService() {
        return toolService;
    }

    public void setToolService(ToolsService toolService) {
        this.toolService = toolService;
    }

    public List<SelectItem> getRuleTypeList() {
        return ruleTypeList;
    }

    public void setRuleTypeList(List<SelectItem> ruleTypeList) {
        this.ruleTypeList = ruleTypeList;
    }

    public RuleType getRuleTypeEnum() {
        return ruleTypeEnum;
    }

    public void setRuleTypeEnum(RuleType ruleTypeEnum) {
        this.ruleTypeEnum = ruleTypeEnum;
    }

    public String getJscript() {
        return jscript;
    }

    public void setJscript(String jscript) {
        this.jscript = jscript;
    }

    public String getDel_inputHidden() {
        return del_inputHidden;
    }

    public void setDel_inputHidden(String del_inputHidden) {
        this.del_inputHidden = del_inputHidden;
    }

    public String getMsgsFlag() {
        return msgsFlag;
    }

    public void setMsgsFlag(String msgsFlag) {
        this.msgsFlag = msgsFlag;
    }
}
