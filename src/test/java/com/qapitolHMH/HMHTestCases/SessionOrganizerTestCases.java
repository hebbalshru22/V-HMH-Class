package com.qapitolHMH.HMHTestCases;

import com.qapitolHMH.HMHBase.BaseClass;
import com.qapitolHMH.HMHPages.LoginPage;
import com.qapitolHMH.HMHPages.SessionOrganizer;
import com.qapitolHMH.HMHPages.SessionOverviewPage;
import com.qapitolHMH.Utility.ReadPropertyfile;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(com.qapitolHMH.Utility.ListenerImplementation.class)
public class SessionOrganizerTestCases extends BaseClass {
    @Test
    public void LoginFunction() {
        try {
            LoginPage lp = new LoginPage(driver);
            lp.logincountry(ReadPropertyfile.getObject("country"),
                    ReadPropertyfile.getObject("state"),
                    ReadPropertyfile.getObject("district"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "LoginFunction")
    public void SessionOrganizer() throws IOException {
        SessionOrganizer mc = new SessionOrganizer(driver);
        mc.SessionOrganizerMethod();
    }

    @Test(dependsOnMethods = {"LoginFunction", "SessionOrganizer"})
    public void Session() {
        SessionOverviewPage so = new SessionOverviewPage(driver);
        so.sessionOverview();
    }
}
