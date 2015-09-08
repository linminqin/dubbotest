package com.lmiky.platform.sort.pojo;

import com.lmiky.platform.database.pojo.BasePojo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 基本排序实体类
 *
 * @author lmiky
 * @date 2013-10-24
 */
@MappedSuperclass
public class BaseSortPojo extends BasePojo {
    private static final long serialVersionUID = 1L;

    public static final String POJO_FIELD_NAME_SORT = "sort";

    public static int DEFAULT_SORT = 0;

    private Integer sort = DEFAULT_SORT;

    /**
     * @return the sort
     */
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
