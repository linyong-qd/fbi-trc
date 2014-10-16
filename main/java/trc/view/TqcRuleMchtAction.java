package trc.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trc.repository.model.TqcRuleMcht;
import trc.service.TqcRuleMchtService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

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


}
