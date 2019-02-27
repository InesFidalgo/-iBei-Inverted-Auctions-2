package FacebookAPI;


import FacebookAPI.OAuthConfig;
import FacebookAPI.OAuthService;

/**
 * Contains all the configuration needed to instantiate a valid {@link OAuthService}
 *
 * @author Pablo Fernandez
 *
 */
public interface Api {

    /**
     *
     * @param config config to build the Service from
     * @return fully configured {@link OAuthService}
     */
    OAuthService createService(OAuthConfig config);
}
