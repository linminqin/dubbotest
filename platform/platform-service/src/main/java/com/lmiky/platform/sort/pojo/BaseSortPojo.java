package com.lmiky.platform.sort.pojo;

import com.lmiky.platform.database.pojo.BasePojo;

import lombok.Getter;
import lombok.Setter;

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

    @Getter
    @Setter
    private Integer sort = DEFAULT_SORT;

}
