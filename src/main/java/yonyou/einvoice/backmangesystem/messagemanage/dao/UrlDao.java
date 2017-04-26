package yonyou.einvoice.backmangesystem.messagemanage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yonyou.einvoice.backmangesystem.messagemanage.entity.CallbackEntity;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;

import java.util.List;

/**
 * Created by xinggq on 17-4-1.
 */
@Mapper
public interface UrlDao {

    /**
     *  查询记录
     * @param conditionUtil
     * @return
     */
    List<CallbackEntity> selectList(ConditionUtil conditionUtil);

    /**
     * 查询记录数
     * @return
     */
    int selectNum(ConditionUtil conditionUtil);

    /**
     * 获取要重发的数据
     * @param ids
     * @return
     */
    List<CallbackEntity> resend(@Param("ids")String[] ids);
}

