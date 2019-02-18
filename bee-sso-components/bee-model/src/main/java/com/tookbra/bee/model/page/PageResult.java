package com.tookbra.bee.model.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tookbra.bee.model.result.BaseResult;
import lombok.Data;
import lombok.ToString;

/**
 * @author tookbra
 * @date 2019/2/15
 * @description
 */
@Data
@ToString
public class PageResult<T> extends BaseResult {
    private static final long serialVersionUID = 1897744787434873073L;

    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private long total;


    public PageResult() {}

    public PageResult(IPage page) {
        super.setData(page.getRecords());
        this.setTotal(page.getTotal());
    }

    public static <T> PageResult success(IPage page) {
        PageResult pageResult = new PageResult(page);
        return pageResult;
    }
}
