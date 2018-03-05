package cn.watson.ticketsystem.presenter;

import android.app.Activity;

import com.google.gson.Gson;
import com.standards.library.cache.SPHelp;

import java.util.List;

import cn.watson.ticketsystem.BuildConfig;
import cn.watson.ticketsystem.base.BasePresenter;
import cn.watson.ticketsystem.bean.TicketType;
import cn.watson.ticketsystem.manager.TicketTypeDataManager;
import cn.watson.ticketsystem.presenter.view.IFollowAddView;

/**
 * @author xiaolong
 * @version v1.0
 * @function <描述功能>
 * @date: 2017/09/11 11:10:50
 */

public class FollowAddPresenter extends BasePresenter<IFollowAddView> {

    public FollowAddPresenter(Activity activity) {
        super(activity);
    }

    public void getMyFollowList() {
        addSubscribe(TicketTypeDataManager.getTicketDataManager().getMyFollowData().subscribe(getSubscriber(ticketTypeList ->
                mView.onGetTicketListSuccess(ticketTypeList)
        )));
    }

    public void cacheList(List<TicketType> ticketTypes) {
        SPHelp.setUserParam(BuildConfig.KEY_MY_FOLLOW, new Gson().toJson(ticketTypes));
    }
}
