package trc.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Vincent on 14-10-15.
 */
@ManagedBean
@ViewScoped
public class BranchRuleAction {
    private static final Logger logger = LoggerFactory.getLogger(BranchRuleAction.class);

    private String mchtCode;
    private String prjCode;
    private String areaCode;
}
