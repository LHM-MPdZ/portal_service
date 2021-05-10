package de.muenchen.demoservicempdz.security;

import org.springframework.stereotype.Component;

@Component
public class UserAuthentication {

    public String getLoggedInUser() {
        return "Peter Pan";
    }
}
