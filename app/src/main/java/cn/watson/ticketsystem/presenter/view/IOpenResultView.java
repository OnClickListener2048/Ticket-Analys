package cn.watson.ticketsystem.presenter.view;

import cn.watson.ticketsystem.base.ILoadingView;
import cn.watson.ticketsystem.bean.TicketOpenData;
import cn.watson.ticketsystem.bean.TicketRegular;

/**
 * @author xiaolong
 * @version v1.0
 * @function <描述功能>
 * @date: 2017/9/8 15:02
 */

public interface IOpenResultView extends ILoadingView {
    void getSingleOpenResultSuccess(TicketOpenData ticketOpenData);

    void getRegularSuccess(TicketRegular ticketRegular);
}
