package Config;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.IOException;

public class BaseProxy extends BaseTest{

    public static BrowserMobProxyServer serverBase;

    @BeforeMethod
    public static void startProxy(){
        serverBase.newHar("youtube");
        UserAgentsCreation.createUserAgent(USERAGENT.ANDROIDEN, serverBase);
    }


    @AfterMethod
    public static void stopProxy(){
        Har har = serverBase.getHar();
        try {
            har.writeTo(new File("youtube.har"));
            serverBase.stop();

            for(HarEntry harEntry : har.getLog().getEntries()){
                harEntry.getRequest().getHeadersSize();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
