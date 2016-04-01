package com.chengli.spring.transaction.env.base;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chengli on 2016/1/26.
 */
public interface IBase {

    @Transactional(rollbackFor = Exception.class)
    void add(int id, String name);

    @Transactional(rollbackFor = Exception.class)
    void update(int id);
}
