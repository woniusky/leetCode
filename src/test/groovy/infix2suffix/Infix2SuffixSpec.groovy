package infix2suffix

import com.zyj.leetcode.infix2suffix.Infix2Suffix
import config.BaseMock
import org.slf4j.LoggerFactory
import spock.lang.Title

import java.util.logging.Logger

@Title("后缀")
class Infix2SuffixSpec extends BaseMock {

    def "test"() {
        when:
        def trans = Infix2Suffix.doTrans("a+b")
        println trans.size()
        then:
        trans.size() > 0
    }

}
