package net.plang.DYAccount.company.applicationService;

import java.util.ArrayList;

import net.plang.DYAccount.company.dao.BusinessDAO;
import net.plang.DYAccount.company.dao.DetailBusinessDAO;
import net.plang.DYAccount.company.to.BusinessBean;
import net.plang.DYAccount.company.to.DetailBusinessBean;

public class BusinessApplicationServiceImpl implements BusinessApplicationService {

	private BusinessDAO businessDAO;
	private DetailBusinessDAO detailbusinessDAO;

	public void setBusinessDAO(BusinessDAO businessDAO) {
		this.businessDAO = businessDAO;
	}

	public void setDetailBusinessDAO(DetailBusinessDAO detailbusinessDAO) {
		this.detailbusinessDAO = detailbusinessDAO;
	}

	// 업태리스트조회
	@Override
	public ArrayList<BusinessBean> getBusinessList() {
		return businessDAO.selectBusinessList(); // 1:M 1
	}

	// 자식 업태 리스트
	@Override
	public ArrayList<DetailBusinessBean> getDetailBusiness(String businessCode) {
		return detailbusinessDAO.selectDetailBusinessList(businessCode); // 1:m 다중
	}

}
