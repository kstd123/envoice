package yonyou.einvoice.backmangesystem.messagemanage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yonyou.einvoice.backmangesystem.messagemanage.entity.EmailEntity;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;

import java.util.List;

/**
 * Created by xinggq on 17-3-31.
 */
@Mapper
public interface EmailDao {


    /**
     *  查询记录
     * @param conditionUtil
     * @return
     */
    List<EmailEntity> selectList(ConditionUtil conditionUtil);

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
    List<EmailEntity> resend(@Param("ids") String[] ids);
}
