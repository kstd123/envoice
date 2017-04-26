package yonyou.einvoice.backmangesystem.messagemanage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yonyou.einvoice.backmangesystem.messagemanage.entity.SmsEntity;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;

import java.util.List;

/**
 * Created by xinggq on 17-4-1.
 */
@Mapper
public interface SmsDao {

    /**
     *  查询记录
     * @param conditionUtil
     * @return
     */
    List<SmsEntity> selectList(ConditionUtil conditionUtil);

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
    List<SmsEntity> resend(@Param("ids")String[] ids);
}
