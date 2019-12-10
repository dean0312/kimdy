package net.plang.DYAccountVer3.base.applicationService;

import java.util.ArrayList;

import net.plang.DYAccountVer3.base.to.SlipIreportBean;

public interface ReportApplicationService {
    /*전표 리포터*/
	public ArrayList<SlipIreportBean> getSlipIreportData(String SlipNo);

}
