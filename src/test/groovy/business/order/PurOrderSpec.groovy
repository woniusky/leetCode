package business.order

import com.zyj.leetcode.business.order.entity.PurOrder
import config.BaseMock

class PurOrderSpec extends BaseMock {


    def "test"() {
        PurOrder purOrder = new PurOrder()
        purOrder.setId(1L)
        purOrderMapper.insert(purOrder)

        expect:
        true
    }
}
