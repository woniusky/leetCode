package config

import com.zyj.leetcode.business.monitor.dao.MonitorMapper
import com.zyj.leetcode.business.order.dao.PurOrderMapper
import org.apache.ibatis.session.SqlSession

class BaseMapper extends BaseSpockInit {

    def purOrderMapper = sqlSession.getMapper(PurOrderMapper.class)

    def monitorMapper = sqlSession.getMapper(MonitorMapper.class)
}

