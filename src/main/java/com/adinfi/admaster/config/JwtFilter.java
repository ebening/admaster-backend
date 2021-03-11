package com.adinfi.admaster.config;

import com.adinfi.admaster.util.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jdominguez on 10/18/16.
 */
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        }else {

            if (authHeader == null || !authHeader.startsWith("Bearer ")){
                throw new ServletException("Access Denied");
            }

            final String token = authHeader.substring(7);

            try{
                final Claims claims = Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);
            }catch (final SignatureException e){
                throw new ServletException("Access Denied");
            }
            chain.doFilter(req, res);
        }
    }
}
