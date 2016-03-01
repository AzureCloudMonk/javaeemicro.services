package com.airhacks.ping.client.boundary;

import com.airhacks.servicelink.boundary.LegacyLink;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class PingService {

    @Inject
    @LegacyLink(name = "ping", portNumber = 8080, path = "/ping/resources/pings/echo/")
    private WebTarget pingTarget;

    public String message() {
        return this.pingTarget.
                path("linked").
                request().
                get(String.class);
    }

}
