package tests;


import methods.PostRequest;
import org.junit.Assert;
import org.junit.Test;
import pojo.SyslogData;

/**
 * Created by root on 07.10.15.
 */
public class Test_Guest {
    @Test
    public void test_addGuest(){
        String message = PostRequest.makeHeader(SyslogData.getGuestDATA(), SyslogData.URL_SYSLOG);
        if (message.contains("FAIL")){
            Assert.fail();
        }
    }
}
