package net.plang.DYAccountVer3.account.statement.dao;

import java.util.ArrayList;

import net.plang.DYAccountVer3.account.statement.to.EarlyAssetBean;

public interface EarlyAssetDAO {
    ArrayList<EarlyAssetBean> findEarlyAssetlist();

    ArrayList<EarlyAssetBean> findEarlyStatementslist();

    ArrayList<EarlyAssetBean> earlyAssetsummarylist();

    ArrayList<EarlyAssetBean> earlyStatelist();

    ArrayList<EarlyAssetBean> earlyStateSummarylist();
}
