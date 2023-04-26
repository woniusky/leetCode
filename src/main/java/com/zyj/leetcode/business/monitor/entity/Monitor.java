package com.zyj.leetcode.business.monitor.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.business.monitor.entity
 * @ClassName: Monitor
 * @Author: honor
 * @Description:
 * @Date: 2023/4/26 19:46
 * @Version: 1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Monitor {
    Long monitorId;
    String makers;
    String owner;
    String series;
}
