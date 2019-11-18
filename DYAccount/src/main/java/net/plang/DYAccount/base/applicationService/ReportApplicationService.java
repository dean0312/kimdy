package net.plang.DYAccount.base.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.base.to.SlipIreportBean;

public interface ReportApplicationService {
    /*전표 리포터*/
	public ArrayList<SlipIreportBean> getSlipIreportData(String SlipNo);

}
