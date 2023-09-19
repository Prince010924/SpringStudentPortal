package com.springapp.StudentPortalSpring.service.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint, Serializable {

    /**
     * This method is called whenever an exception is thrown due to an unauthenticated user trying to access a resource that requires authentication.
     * @param request The request.
     * @param response The response.
     * @param authException The authentication exception.
     * @throws IOException The IOException.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
