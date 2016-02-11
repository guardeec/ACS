package tests;


import methods.PostRequest;
import org.junit.Assert;
import org.junit.Test;
import pojo.SyslogData;

/**
 * Created by root on 07.10.15.
 */
public class Test_Employer {
    @Test
    public void test_addEmployee(){
        String message = PostRequest.makeHeader(SyslogData.getEmployeeDATA(), SyslogData.URL_SYSLOG);
        if (message.contains("FAIL")){
            Assert.fail();
        }
    }
}
