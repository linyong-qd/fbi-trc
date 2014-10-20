package trc.view;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.common.utils.MessageUtil;
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

    private TqcRulePub tqcRulePub;
    @ManagedProperty(value = "#{tqcRulePubService}")
    private TqcRulePubService pubService;
    private List<TqcRulePub> ruleList = new ArrayList<TqcRulePub>();
    private TqcRulePub[] selectedRuleRecords;
    private String jscript;

    @PostConstruct
    public void init() {
        tqcRulePub = new TqcRulePub();
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


    public String onInsert() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getSingleLim()) >= 0) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getDayTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            // ȷ�ϸù����Ƿ��Ѿ�����
            if (pubService.isRuleExist(tqcRulePub.getRuleType().trim())) {
                MessageUtil.addError("�ù����Ѵ���!");
                return null;
            }
            pubService.insertRule(tqcRulePub);
            logger.info("����������������ɹ����������ͣ�"+tqcRulePub.getRuleType()+"  ���ʽ�"+tqcRulePub.getSingleLim()+" ���ۼ��޶�:"+tqcRulePub.getDayTotalLim()+" ���ۼ��޶�:"+tqcRulePub.getMonthTotalLim());
            MessageUtil.addInfo("����������������ɹ���");
            ruleList.add(tqcRulePub);
        } catch (Exception e) {
            logger.error("���������������ʧ�ܡ�", e);
            MessageUtil.addError("�¹�����Ӳ���ʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    public String onQuery() {
        try {
            ruleList = pubService.qryRuleByRuleType(ruleType);
            if (ruleList.size() == 0) {
                MessageUtil.addWarn("û�в�ѯ�����ݼ�¼��");
            }
        } catch (Exception e) {
            logger.error("��ѯ��������ʧ�ܡ�", e);
            MessageUtil.addError("��ѯ������Ϣ��¼ʧ�ܡ�");
        }
        return null;
    }

    public String onUpdate() {
        try {

            if (new BigDecimal(0.00).compareTo(tqcRulePub.getSingleLim()) >= 0) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getDayTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRulePub.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            pubService.updateRule(tqcRulePub);
            logger.info("����������¹���ɹ����������ͣ�"+tqcRulePub.getRuleType()+"  ���ʽ�"+tqcRulePub.getSingleLim()+" ���ۼ��޶�:"+tqcRulePub.getDayTotalLim()+" ���ۼ��޶�:"+tqcRulePub.getMonthTotalLim());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("���¹���������Ϣʧ�ܡ�", e);
            MessageUtil.addError("���¹�����Ϣʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    public String onDelete() {
        try {
            if (selectedRuleRecords == null || selectedRuleRecords.length == 0) {
                MessageUtil.addWarn("����ѡ��һ�ʼ�¼��");
                return null;
            }
            pubService.deleteRule(tqcRulePub);
            logger.info("��������ɾ������ɹ����������ͣ�"+tqcRulePub.getRuleType()+"  ���ʽ�"+tqcRulePub.getSingleLim()+" ���ۼ��޶�:"+tqcRulePub.getDayTotalLim()+" ���ۼ��޶�:"+tqcRulePub.getMonthTotalLim());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
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

    public TqcRulePub[] getSelectedRuleRecords() {
        return selectedRuleRecords;
    }

    public void setSelectedRuleRecords(TqcRulePub[] selectedRuleRecords) {
        this.selectedRuleRecords = selectedRuleRecords;
    }

    public String getJscript() {
        return jscript;
    }

    public void setJscript(String jscript) {
        this.jscript = jscript;
    }
}
