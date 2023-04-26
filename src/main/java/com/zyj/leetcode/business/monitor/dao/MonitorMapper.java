package com.zyj.leetcode.business.monitor.dao;

import com.zyj.leetcode.business.monitor.entity.Monitor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonitorMapper {

    Monitor selectByPrimaryKey(Long id);

}