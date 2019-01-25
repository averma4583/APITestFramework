//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tests;

import core.APIClient;
import java.net.HttpURLConnection;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAPI {
    APIClient api;
    HttpURLConnection response;

    public TestAPI() {
    }

    @BeforeSuite
    public void setUp() {
        this.api = new APIClient();
    }

    @Test(
            priority = 2
    )
    public void testGetStatusCode() {
        try {
            this.response = this.api.sendGet("https://news.google.com/?hl=en-US&gl=US&ceid=US:en");
            Assert.assertEquals(this.response.getResponseCode(), 200);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    @Test(
            priority = 1
    )
    public void testPostStatusCode() {
        try {
            this.response = this.api.sendPost("https://selfsolve.apple.com/wcResults.do");

            assert this.response.getResponseCode() == 200;
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    @Test(
            priority = 3
    )
    public void testGetBody() {
        try {
            this.response = this.api.sendGet("https://news.google.com/?hl=en-US&gl=US&ceid=US:en");
            Assert.assertTrue(this.response.getContent().toString().contains("sun.net.www.protocol.http"));
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    @Test(
            priority = 4
    )
    public void testPostResponseMessage() {
        try {
            this.response = this.api.sendPost("https://selfsolve.apple.com/wcResults.do");
            Assert.assertEquals(this.response.getResponseMessage(), "OK");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    @Test(
            priority = 5
    )
    public void testcheckProxy() {
        try {
            this.response = this.api.sendPost("https://selfsolve.apple.com/wcResults.do");
            Assert.assertFalse(this.response.usingProxy());
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
