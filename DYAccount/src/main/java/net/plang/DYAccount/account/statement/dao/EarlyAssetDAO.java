package net.plang.DYAccount.account.statement.dao;

import java.util.ArrayList;

import net.plang.DYAccount.account.statement.to.EarlyAssetBean;

public interface EarlyAssetDAO {
    ArrayList<EarlyAssetBean> findEarlyAssetlist();

    ArrayList<EarlyAssetBean> findEarlyStatementslist();

    ArrayList<EarlyAssetBean> earlyAssetsummarylist();

    ArrayList<EarlyAssetBean> earlyStatelist();

    ArrayList<EarlyAssetBean> earlyStateSummarylist();
}
