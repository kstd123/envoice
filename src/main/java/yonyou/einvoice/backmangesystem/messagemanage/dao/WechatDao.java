package yonyou.einvoice.backmangesystem.messagemanage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yonyou.einvoice.backmangesystem.messagemanage.entity.WechatEntity;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;

import java.util.List;

/**
 * Created by xinggq on 17-4-5.
 */
@Mapper
public interface WechatDao {

    /**
     *  查询记录
     * @param conditionUtil
     * @return
     */
    List<WechatEntity> selectList(ConditionUtil conditionUtil);

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
    List<WechatEntity> resend(@Param("ids")String[] ids);
}
