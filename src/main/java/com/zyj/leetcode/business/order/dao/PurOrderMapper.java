package com.zyj.leetcode.business.order.dao;

import com.zyj.leetcode.business.order.entity.PurOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PurOrder record);

    int insertSelective(PurOrder record);

    PurOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PurOrder record);

    int updateByPrimaryKeyWithBLOBs(PurOrder record);

    int updateByPrimaryKey(PurOrder record);

    void batchInsert(List<PurOrder> list);
}