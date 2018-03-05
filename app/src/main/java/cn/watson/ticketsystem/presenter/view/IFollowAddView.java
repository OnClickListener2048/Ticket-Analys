package cn.watson.ticketsystem.presenter.view;

import java.util.List;

import cn.watson.ticketsystem.base.ILoadingView;
import cn.watson.ticketsystem.bean.TicketType;

/**
 * @author xiaolong
 * @version v1.0
 * @function <描述功能>
 * @date: 2017/9/11 11:17
 */

public interface IFollowAddView extends ILoadingView {
    void onGetTicketListSuccess(List<TicketType> ticketTypeList);
}
