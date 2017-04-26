package yonyou.einvoice.backmangesystem.util;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xinggq on 17-3-31.
 *
 * 分页工具类
 */
@Component
public class PageUtil {

    private int pageNow;//当前所在页

    private int rowAll;//总数据数

    private int pageNum;//每页显示的数据数

    private int pageNumStart;//当前页从第几条数据开始展示

    private List list;//当前页的所有数据


    public int getRowAll() {
        return rowAll;
    }

    public void setRowAll(int rowAll) {
        this.rowAll = rowAll;
    }

    public int getPageNumStart() {
        //如果小于0的话就返回0
        return (pageNow-1)*pageNum<0?0:(pageNow-1)*pageNum;
    }

    public void setPageNumStart(int pageNumStart) {
        this.pageNumStart = pageNumStart;
    }



    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }



    public int getPageNum() {
        //如果小于0的话就返回0
        return pageNum<0?0:pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
