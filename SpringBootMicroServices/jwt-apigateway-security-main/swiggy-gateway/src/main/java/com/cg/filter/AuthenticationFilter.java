package com.cg.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.cg.dto.RoleDTO;
import com.cg.util.JwtUtil;

import io.jsonwebtoken.Claims;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    //    @Autowired
//    private RestTemplate template;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                    jwtUtil.validateToken(authHeader);

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
                
                
                try {
                    // Validate token and extract claims
                    Claims claims = jwtUtil.validateTokenWithRoles(authHeader);
                    List<RoleDTO> roles = claims.get("roles", List.class);
                    System.out.println(roles);
                    // Role-based validation (example: allow only ADMIN role for specific routes)
                    String path = exchange.getRequest().getPath().toString();
                    System.out.println("Path="+path);
	                    if(roles!=null && roles.size()>0) {
	                    if (path.startsWith("/admin") && !roles.get(0).getName().equals("ROLE_ADMIN")) {
	                        throw new RuntimeException("Unauthorized access for this role");
	                    }
	
	                    if (path.startsWith("/user") && !roles.get(0).getName().equals("ROLE_USER")) {
	                        throw new RuntimeException("Unauthorized access for this role");
	                    }
                    }

                    

                } catch (Exception e) {
                	e.printStackTrace();
                    throw new RuntimeException("Unauthorized access: " + e.getMessage());
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}
