package com.webapp.webdemo.security;

import com.webapp.webdemo.service.impl.CustomUserDetailsServiceImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.webapp.webdemo.constants.CommonConstants.*;

@Setter(onMethod_ = {@Autowired})
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String jwt = getJwtFromRequest(request);
            if(StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)){
                Long userNo = jwtTokenProvider.getUserNoFromJWT(jwt);
                UserDetails userDetails = customUserDetailsService.loadUserByUserNo(userNo);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e){
            log.error("Could not set user authentication in security context", e);
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(HeaderConstants.BEARER_TOKEN);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(HttpHeaders.AUTHORIZATION)){
            return bearerToken.substring(HeaderConstants.BEARER_TOKEN.length());
        }
        return null;
    }
}