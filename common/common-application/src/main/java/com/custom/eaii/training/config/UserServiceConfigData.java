package com.custom.eaii.training.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
        prefix = "user-api"
)
public class UserServiceConfigData {
    private String url;
    private String createUser;
    private String createLicenseUser;
    private String findUser;

    public UserServiceConfigData() {
    }

    public String getUrl() {
        return this.url;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public String getCreateLicenseUser() {
        return this.createLicenseUser;
    }

    public String getFindUser() {
        return this.findUser;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setCreateLicenseUser(String createLicenseUser) {
        this.createLicenseUser = createLicenseUser;
    }

    public void setFindUser(String findUser) {
        this.findUser = findUser;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserServiceConfigData)) {
            return false;
        } else {
            UserServiceConfigData other = (UserServiceConfigData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$url = this.getUrl();
                    Object other$url = other.getUrl();
                    if (this$url == null) {
                        if (other$url == null) {
                            break label59;
                        }
                    } else if (this$url.equals(other$url)) {
                        break label59;
                    }

                    return false;
                }

                Object this$createUser = this.getCreateUser();
                Object other$createUser = other.getCreateUser();
                if (this$createUser == null) {
                    if (other$createUser != null) {
                        return false;
                    }
                } else if (!this$createUser.equals(other$createUser)) {
                    return false;
                }

                Object this$createLicenseUser = this.getCreateLicenseUser();
                Object other$createLicenseUser = other.getCreateLicenseUser();
                if (this$createLicenseUser == null) {
                    if (other$createLicenseUser != null) {
                        return false;
                    }
                } else if (!this$createLicenseUser.equals(other$createLicenseUser)) {
                    return false;
                }

                Object this$findUser = this.getFindUser();
                Object other$findUser = other.getFindUser();
                if (this$findUser == null) {
                    if (other$findUser != null) {
                        return false;
                    }
                } else if (!this$findUser.equals(other$findUser)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof UserServiceConfigData;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $url = this.getUrl();
        result = result * 59 + ($url == null ? 43 : $url.hashCode());
        Object $createUser = this.getCreateUser();
        result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
        Object $createLicenseUser = this.getCreateLicenseUser();
        result = result * 59 + ($createLicenseUser == null ? 43 : $createLicenseUser.hashCode());
        Object $findUser = this.getFindUser();
        result = result * 59 + ($findUser == null ? 43 : $findUser.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getUrl();
        return "UserServiceConfigData(url=" + var10000 + ", createUser=" + this.getCreateUser() + ", createLicenseUser=" + this.getCreateLicenseUser() + ", findUser=" + this.getFindUser() + ")";
    }
}
