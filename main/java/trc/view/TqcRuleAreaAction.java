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
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getDayTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            // ȷ�ϸù����Ƿ��Ѿ�����
            if (areaService.isRuleExist(tqcRuleArea.getAreaCode().trim())) {
                MessageUtil.addError("�ù����Ѵ���!");
                return null;
            }
            areaService.insertRule(tqcRuleArea);
            logger.info("��ҵ������������ɹ�����ҵ�����ţ�"+tqcRuleArea.getAreaCode()+"  ��ҵ�������ƣ�"+tqcRuleArea.getAreaName());
            MessageUtil.addInfo("�¹�����Ӳ����ɹ�����ҵ�����ţ�"+tqcRuleArea.getAreaCode());
            ruleList.add(tqcRuleArea);
        } catch (Exception e) {
            logger.error("��ҵ���������������ʧ�ܡ�", e);
            MessageUtil.addError("��ҵ���������������ʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    public String onQuery() {
        try {

            ruleList = areaService.qryRuleByAreaCode(areaCode);
            if (ruleList.size() == 0) {
                MessageUtil.addWarn("û�в�ѯ�����ݼ�¼��");
            }
        } catch (Exception e) {
            logger.error("��ѯ��ҵ�������ʧ�ܡ�", e);
            MessageUtil.addError("��ѯ������Ϣ��¼ʧ�ܡ�");
        }
        return null;
    }

    public String onUpdate() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getSingleLim()) >= 0) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getDayTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleArea.getMonthTotalLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            areaService.updateRule(tqcRuleArea);
            logger.info("��ҵ������¹���ɹ�����ҵ�����ţ�"+tqcRuleArea.getAreaCode()+"  ��ҵ�������ƣ�"+tqcRuleArea.getAreaName());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("��ҵ������¹���ʧ�ܡ�", e);
            MessageUtil.addError("��ҵ������¹���ʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    public String onDelete() {
        try {
            if (selectedRuleRecords == null || selectedRuleRecords.length == 0) {
                MessageUtil.addWarn("����ѡ��һ�ʼ�¼��");
                return null;
            }
            areaService.deleteRule(tqcRuleArea);
            logger.info("��ҵ����ɾ������ɹ�����ҵ�����ţ�"+tqcRuleArea.getAreaCode()+"  ��ҵ�������ƣ�"+tqcRuleArea.getAreaName());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("ɾ����ҵ���������Ϣʧ�ܡ�", e);
            MessageUtil.addError("ɾ����ҵ���������Ϣʧ�ܡ�" + e.getMessage());
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
