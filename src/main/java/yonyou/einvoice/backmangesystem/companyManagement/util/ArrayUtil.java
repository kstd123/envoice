package yonyou.einvoice.backmangesystem.companyManagement.util;

import org.apache.commons.lang.ArrayUtils;

public final class ArrayUtil {

	 /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
