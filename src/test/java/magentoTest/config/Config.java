package magentoTest.config;

public class Config {

    private final String uiUrl;
    private final String browser;
    private final String username;
    private final String password;

    public Config(){
        browser = "chrome";
        uiUrl = "https://magento.softwaretestingboard.com/";
        username = "leunammeu23@gmail.com";
        password = "Test1234";
    }

    public String getUiUrl() {
        return uiUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
