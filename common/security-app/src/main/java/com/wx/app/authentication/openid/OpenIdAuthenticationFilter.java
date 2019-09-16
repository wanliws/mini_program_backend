package com.wx.app.authentication.openid;

import com.wx.properties.SecurityConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The class open id authentication filter
 */
public class OpenIdAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    // ~ Static fields/initializers
    private String openIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_OPENID;
    private String providerIdParameter = SecurityConstants.DEAFULT_PARAMETER_NAME_PROVIDERID;
    private boolean postOnly = true;
    private static final String POST = "POST";

    /**
     * Instantiates a new Open id authentication filter.
     */
    OpenIdAuthenticationFilter() {
        super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID, "POST"));
    }

    /**
     * Attempt authentication authentication.
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        if (postOnly && !POST.equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String openid = obtainOpenId(request);
        String providerId = obtainProviderId(request);

        if (openid == null) {
            openid = "";
        }
        if (providerId == null) {
            providerId = "";
        }

        openid = openid.trim();
        providerId = providerId.trim();

        OpenIdAuthenticationToken
        return null;
    }
}
