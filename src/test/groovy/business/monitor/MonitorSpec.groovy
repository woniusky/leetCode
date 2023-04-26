package business.monitor

import com.zyj.leetcode.business.monitor.entity.Monitor
import config.BaseMock
import spock.lang.Title

@Title("monitor")
class MonitorSpec extends BaseMock {

    def "test"() {
        def key = monitorMapper.selectByPrimaryKey(1L)
        println key

        expect:
        true
    }
}
