package net.plang.DYAccountVer3.company.applicationService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.plang.DYAccountVer3.company.dao.BusinessDAO;
import net.plang.DYAccountVer3.company.dao.DetailBusinessDAO;
import net.plang.DYAccountVer3.company.to.BusinessBean;
import net.plang.DYAccountVer3.company.to.DetailBusinessBean;

@Component
@Transactional
public class BusinessApplicationServiceImpl implements BusinessApplicationService {
	@Autowired
	private BusinessDAO businessDAO;
	@Autowired
	private DetailBusinessDAO detailbusinessDAO;

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
