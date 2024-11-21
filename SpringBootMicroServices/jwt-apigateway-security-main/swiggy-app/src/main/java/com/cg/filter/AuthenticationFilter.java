package com.cg.filter;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthenticationFilter implements jakarta.servlet.Filter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authHeader = httpRequest.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Missing or invalid Authorization header");
            return;
        }

        String token = authHeader.substring(7);

        try {
            // Validate token
            Claims claims = jwtUtil.validateTokenWithRoles(token);

            // Extract roles
            List<?> rolesMap = claims.get("roles", List.class);
            String path = httpRequest.getRequestURI();
            System.out.println("Path: " + path);

            List<RoleDTO> roles = new ArrayList<>();

            for (Object roleMap : rolesMap) {
                // Convert LinkedHashMap to RoleDTO
                ObjectMapper objectMapper = new ObjectMapper();

                RoleDTO role = objectMapper.convertValue(roleMap, RoleDTO.class);
                roles.add(role);
            }
            System.out.println(roles);
            // Perform role-based authorization
            if (roles != null && roles.size() > 0) {
                String role = roles.get(0).getName();
                if (path.startsWith("/admin") && !"ROLE_ADMIN".equals(role)) {
                    throw new RuntimeException("Unauthorized access for this role");
                }
                if (path.startsWith("/user") && !"ROLE_USER".equals(role)) {
                    throw new RuntimeException("Unauthorized access for this role");
                }
            }

        } catch (Exception e) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Unauthorized: " + e.getMessage());
            return;
        }

        // Continue the filter chain
        chain.doFilter(request, response);
    }
}
