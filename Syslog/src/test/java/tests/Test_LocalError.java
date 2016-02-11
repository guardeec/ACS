package tests;


import methods.PostRequest;
import org.junit.Assert;
import org.junit.Test;
import pojo.SyslogData;

/**
 * Created by root on 29.10.15.
 */
public class Test_LocalError {
    @Test
    public void test_localError(){
        String message = PostRequest.makeHeader(SyslogData.getLocalErrorDATA(), SyslogData.URL_SYSLOG);
        if (message.contains("FAIL")){
            Assert.fail();
        }
    }
}
