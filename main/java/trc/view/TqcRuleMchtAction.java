package trc.view;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.common.utils.MessageUtil;
import trc.repository.model.TqcRuleAcctKey;
import trc.repository.model.TqcRuleMcht;
import trc.repository.model.TqcRuleMchtKey;
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
 * Created by Vincent on 14-10-16.
 */
@ManagedBean
@ViewScoped
public class TqcRuleMchtAction {
    private static final Logger logger = LoggerFactory.getLogger(TqcRuleMchtAction.class);

    private String mchtCode;
    private String prjCode;
    private String del_inputHidden;
    private String msgsFlag;
    private TqcRuleMcht tqcRuleMcht;
    @ManagedProperty(value = "#{tqcRuleMchtService}")
    private  TqcRuleMchtService mchtService;
    private List<TqcRuleMcht> ruleList = new ArrayList<TqcRuleMcht>();
    private TqcRuleMcht selectedRuleRecord;
    private String jscript;

    @PostConstruct
    public void init() {
        tqcRuleMcht = new TqcRuleMcht();
        //ҳ���ʼ����ʾ��ȫ������
        ruleList= mchtService.qryRuleByMchtCodePrjCode(null,null);//getAllTqcRuleMcht();
        initRuleInfo();
    }

    public void initRuleInfo(){
        Map<String, String> paramsmap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String pkid = paramsmap.get("pkid");
        String action = paramsmap.get("action");
        logger.info("PKID: " + pkid + " ACTION:" + action);
        if (!StringUtils.isEmpty(pkid) && !StringUtils.isEmpty(action)) {
            if ("update".equalsIgnoreCase(action)) {
                String[] key = pkid.split(",");
                TqcRuleMchtKey pk = new TqcRuleMchtKey();
                pk.setMchtCode(key[0]);
                pk.setPrjCode(key[1]);
                tqcRuleMcht = mchtService.qryRuleByKey(pk);
            }
        }
    }

    /**
     * ����տλ����
     */
    public String onInsert() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getSingleLim()) >= 0) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getDayAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getMonthAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            // ȷ�ϸù����Ƿ��Ѿ�����
            if (mchtService.isRuleExist(tqcRuleMcht.getMchtCode().trim(), tqcRuleMcht.getPrjCode())) {
                MessageUtil.addError("�ù����Ѵ���!");
                return null;
            }
            mchtService.insertRule(tqcRuleMcht);
            logger.info("�տλ��������ɹ����տλ�ͻ��ţ�"+tqcRuleMcht.getMchtCode()+"  ��Ŀ��ţ�"+tqcRuleMcht.getPrjCode());
            MessageUtil.addInfo("�¹�����Ӳ����ɹ����տ�ͻ��ţ�" + tqcRuleMcht.getMchtCode());
            ruleList.add(tqcRuleMcht);
        } catch (Exception e) {
            logger.error("�¹�����Ӳ���ʧ�ܡ�", e);
            MessageUtil.addError("�¹�����Ӳ���ʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    /**
     * ��ѯ�տλ����
     */
    public String onQuery() {
        try {
            ruleList = mchtService.qryRuleByMchtCodePrjCode(mchtCode,prjCode);
            if (ruleList.size() == 0&&!"delete".equals(msgsFlag)) {
                MessageUtil.addWarn("û�в�ѯ�����ݼ�¼��");
            }
        } catch (Exception e) {
            logger.error("��ѯ������Ϣ��¼ʧ�ܡ�", e);
            MessageUtil.addError("��ѯ������Ϣ��¼ʧ�ܡ�");
        }
        return null;
    }

    /**
     * �����տλ����
     */
    public String onUpdate() {
        try {
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getSingleLim()) >= 0) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getDayAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (new BigDecimal(0.00).compareTo(tqcRuleMcht.getMonthAmtLim()) >= 0) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            mchtService.updateRule(tqcRuleMcht);
            logger.info("�տλ���¹���ɹ����տλ�ͻ��ţ�"+tqcRuleMcht.getMchtCode()+"  ��Ŀ��ţ�"+tqcRuleMcht.getPrjCode());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("���¹�����Ϣʧ�ܡ�", e);
            MessageUtil.addError("���¹�����Ϣʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    /**
     * ɾ���տλ����
     */
    public String onDelete() {
        try {
//            if (selectedRuleRecord == null) {
//                MessageUtil.addWarn("��ѡ��һ�ʼ�¼��");
//                return null;
//            }
            String[] key = del_inputHidden.split(",");
            TqcRuleMchtKey pk = new TqcRuleMchtKey();
            pk.setMchtCode(key[0]);
            pk.setPrjCode(key[1]);
            tqcRuleMcht = mchtService.qryRuleByKey(pk);

            mchtService.deleteRule(tqcRuleMcht);
            ruleList.remove(tqcRuleMcht);
            logger.info("�տλ����ɾ���ɹ����տλ�ͻ��ţ�"+tqcRuleMcht.getMchtCode()+"  ��Ŀ��ţ�"+tqcRuleMcht.getPrjCode());
            MessageUtil.addInfo("�տλ����ɾ���ɹ���");
        } catch (Exception e) {
            logger.error("���¹�����Ϣʧ�ܡ�", e);
            MessageUtil.addError("���¹�����Ϣʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    public int getRowKey() {
        return this.hashCode();
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

    public String getMchtCode() {
        return mchtCode;
    }

    public void setMchtCode(String mchtCode) {
        this.mchtCode = mchtCode;
    }

    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode;
    }

    public TqcRuleMcht getSelectedRuleRecord() {
        return selectedRuleRecord;
    }

    public void setSelectedRuleRecord(TqcRuleMcht selectedRuleRecord) {
        this.selectedRuleRecord = selectedRuleRecord;
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
