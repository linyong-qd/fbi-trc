package trc.view;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import skyline.common.utils.MessageUtil;
import skyline.service.ToolsService;
import trc.common.enums.AcctType;
import trc.common.enums.AreaRuleFlag;
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
import javax.faces.event.ValueChangeEvent;
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
    private String del_inputHidden;
    private String msgsFlag;
    //�Ƿ�ʹ����ҵ��������ǩ
    private Boolean render;

    private TqcRuleAcct tqcRuleAcct;
    @ManagedProperty(value = "#{tqcRuleAcctService}")
    private TqcRuleAcctService acctService;
    @ManagedProperty(value = "#{toolsService}")
    private ToolsService toolService;
    private List<TqcRuleAcct> ruleList = new ArrayList<TqcRuleAcct>();
    private TqcRuleAcct selectedRuleRecord;
    private String jscript;


    private List<SelectItem> acctTypeList;
    private List<SelectItem> areaRuleFlagList;

    private AcctType acctTypeEnum = AcctType.MERCHANT;
    private AreaRuleFlag areaRuleFlagEnum=AreaRuleFlag.MERCHANT;

    @PostConstruct
    public void init() {
        tqcRuleAcct = new TqcRuleAcct();
        acctTypeList = toolService.getEnuSelectItemList("ACCTTYPE",false,false);
        acctTypeList.add(0, new SelectItem("", ""));

        areaRuleFlagList = toolService.getEnuSelectItemList("AREARULEFLAG",false,false);
        areaRuleFlagList.add(0, new SelectItem("", ""));
        initRuleInfo();
        render=false;
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
     * ��ӱ��۵�λ����
     */
    public String onInsert() {
        try {
            if (tqcRuleAcct.getSingleLim().compareTo(new BigDecimal(0.00))==-1) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (tqcRuleAcct.getDayAmtLim().compareTo(new BigDecimal(0.00))==-1) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (tqcRuleAcct.getMonthAmtLim().compareTo(new BigDecimal(0.00))==-1) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            if("2".equals(tqcRuleAcct.getAcctType())&&"0".equals(tqcRuleAcct.getAreaRuleFlag())){
                if (tqcRuleAcct.getSingleLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("�����޶��������!");
                    return null;
                }
                if (tqcRuleAcct.getDayAmtLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("���ۼ��޶��������!");
                    return null;
                }
                if (tqcRuleAcct.getMonthAmtLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("���ۼ��޶��������!");
                    return null;
                }
            }
            /*
            else if("2".equals(tqcRuleAcct.getAcctType())&&"1".equals(tqcRuleAcct.getAreaRuleFlag())){
                if (tqcRuleAcct.getSingleLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("�����޶��������!");
                    return null;
                }
                if (tqcRuleAcct.getDayAmtLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("���ۼ��޶��������!");
                    return null;
                }
                if (tqcRuleAcct.getMonthAmtLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("���ۼ��޶��������!");
                    return null;
                }
            }*/

            // ȷ�ϸù����Ƿ��Ѿ�����
            if (acctService.isRuleExist(tqcRuleAcct.getMchtCode().trim(), tqcRuleAcct.getPrjCode().trim(),tqcRuleAcct.getAcctType().trim())) {
                MessageUtil.addError("�ù����Ѵ���!");
                return null;
            }

            if("".equals(tqcRuleAcct.getAreaRuleFlag())||tqcRuleAcct.getAreaRuleFlag()==null){
                tqcRuleAcct.setAreaRuleFlag(String.valueOf(0));
            }

            acctService.insertRule(tqcRuleAcct);
            logger.info("������������ɹ������۵�λ�ͻ��ţ�"+tqcRuleAcct.getMchtCode()+"  ��Ŀ��ţ�"+tqcRuleAcct.getPrjCode());
            MessageUtil.addInfo("�¹�����Ӳ����ɹ������ۿͻ��ţ�" + tqcRuleAcct.getMchtCode());
            ruleList.add(tqcRuleAcct);
        } catch (Exception e) {
            logger.error("��ӱ��۵�λ�������ʧ�ܡ�", e);
            MessageUtil.addError("�¹�����Ӳ���ʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    /**
     * ��ѯ���۵�λ����
     */
    public String onQuery() {
        try {
            ruleList = acctService.qryRuleByAcctCodePrjCodeAcctType(acctCode, prjCode,tqcRuleAcct.getAcctType());
            if (ruleList.size() == 0&&!"delete".equals(msgsFlag)) {
                MessageUtil.addWarn("û�в�ѯ�����ݼ�¼��");
            }

        } catch (Exception e) {
            logger.error("��ѯ���۵�λ����ʧ�ܡ�", e);
            MessageUtil.addError("��ѯ������Ϣ��¼ʧ�ܡ�");
        }
        return null;
    }

    /**
     * ������ҵ�������
     */
    public String onUpdate() {
        try {

            if (tqcRuleAcct.getSingleLim().compareTo(new BigDecimal(0.00))==-1) {
                MessageUtil.addError("�����޶�����������!");
                return null;
            }
            if (tqcRuleAcct.getDayAmtLim().compareTo(new BigDecimal(0.00))==-1) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }
            if (tqcRuleAcct.getMonthAmtLim().compareTo(new BigDecimal(0.00))==-1) {
                MessageUtil.addError("���ۼ��޶�����������!");
                return null;
            }

            if("2".equals(tqcRuleAcct.getAcctType())&&"0".equals(tqcRuleAcct.getAreaRuleFlag())){
                if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getSingleLim()) == 0) {
                    MessageUtil.addError("�����޶����������!");
                    return null;
                }
                if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getDayAmtLim()) == 0) {
                    MessageUtil.addError("���ۼ��޶����������!");
                    return null;
                }
                if (new BigDecimal(0.00).compareTo(tqcRuleAcct.getMonthAmtLim())== 0) {
                    MessageUtil.addError("���ۼ��޶����������!");
                    return null;
                }
            }
            /*
            else{
                if (tqcRuleAcct.getSingleLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("�����޶��������!");
                    return null;
                }
                if (tqcRuleAcct.getDayAmtLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("���ۼ��޶��������!");
                    return null;
                }
                if (tqcRuleAcct.getMonthAmtLim().compareTo(new BigDecimal(0.00))==0) {
                    MessageUtil.addError("���ۼ��޶��������!");
                    return null;
                }
            }*/

            acctService.updateRule(tqcRuleAcct);
            logger.info("���±��۵�λ����ɹ������۵�λ�ͻ��ţ�"+tqcRuleAcct.getMchtCode()+"  ��Ŀ��ţ�"+tqcRuleAcct.getPrjCode());
            jscript = "<script language='javascript'>closeThisWindow('true');</script>";
        } catch (Exception e) {
            logger.error("���±��۵�λ������Ϣʧ�ܡ�", e);
            MessageUtil.addError("���±��۵�λ������Ϣʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    /**
     * ɾ�����۵�λ����
     */
    public String onDelete() {
        try {
//            if (selectedRuleRecord == null) {
//                MessageUtil.addWarn("����ѡ��һ�ʼ�¼��");
//                return null;
//            }
            String[] key = del_inputHidden.split(",");
            TqcRuleAcctKey pk = new TqcRuleAcctKey();
            pk.setMchtCode(key[0]);
            pk.setPrjCode(key[1]);
            pk.setAcctType(key[2]);

            tqcRuleAcct = acctService.qryRuleByKey(pk);

            acctService.deleteRule(tqcRuleAcct);
            ruleList.remove(tqcRuleAcct);
           // acctService.deleteRule(tqcRuleAcct);
            logger.info("ɾ�����۵�λ����ɹ������۵�λ�ͻ��ţ�"+tqcRuleAcct.getMchtCode()+"  ��Ŀ��ţ�"+tqcRuleAcct.getPrjCode());

        } catch (Exception e) {
            logger.error("ɾ�����۵�λ����ʧ�ܡ�", e);
            MessageUtil.addError("ɾ�����۵�λ����ʧ�ܡ�" + e.getMessage());
        }
        return null;
    }

    /**
     * �˺�����Ϊ��˽ʱ
     * @return
     */
    public String changeAcctType(ValueChangeEvent event){
        String  acctType=event.getNewValue().toString();//�õ�ҳ�洫������acctType
        FacesContext facesContext=FacesContext.getCurrentInstance();
        if("2".equals(acctType)){
            render=true;
            //tqcRuleAcct.setAreaRuleFlag(String.valueOf(1));
        }else{
            render=false;
            //tqcRuleAcct.setAreaRuleFlag(String.valueOf(0));
        }
        facesContext.renderResponse();
        return null;
    }

    /*
    public String updateChangeAcctType(ValueChangeEvent event){
        String  acctType=event.getNewValue().toString(); //�õ�ҳ�洫������acctType
        FacesContext facesContext=FacesContext.getCurrentInstance();
        if("2".equals(acctType)){
            render=true;
            //tqcRuleAcct.setAreaRuleFlag(String.valueOf(1));
        }else{
            render=false;
            //tqcRuleAcct.setAreaRuleFlag(String.valueOf(0));
        }
        facesContext.renderResponse();
        return null;
    }
    */




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

    public List<SelectItem> getAreaRuleFlagList() {
        return areaRuleFlagList;
    }

    public void setAreaRuleFlagList(List<SelectItem> areaRuleFlagList) {
        this.areaRuleFlagList = areaRuleFlagList;
    }

    public Boolean getRender() {
        return render;
    }

    public void setRender(Boolean render) {
        this.render = render;
    }

    public AreaRuleFlag getAreaRuleFlagEnum() {
        return areaRuleFlagEnum;
    }

    public void setAreaRuleFlagEnum(AreaRuleFlag areaRuleFlagEnum) {
        this.areaRuleFlagEnum = areaRuleFlagEnum;
    }
}
