package org.mayocat.shop.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mayocat.shop.authorization.annotation.Authorized;
import org.mayocat.shop.configuration.tenant.ShopConfiguration;
import org.mayocat.shop.rest.annotation.ExistingTenant;
import org.mayocat.shop.service.ConfigurationService;
import org.slf4j.Logger;
import org.xwiki.component.annotation.Component;

import com.yammer.metrics.annotation.Timed;

@Component("ConfigurationResource")
@Path("/configuration/")
@Produces(MediaType.APPLICATION_JSON)
@ExistingTenant
@Authorized
public class ConfigurationResource implements Resource
{
    @Inject
    private Logger logger;

    @Inject
    private ConfigurationService configurationService;

    @GET
    @Timed
    public ShopConfiguration getConfiguration()
    {
        return configurationService.getConfiguration();
    }
}