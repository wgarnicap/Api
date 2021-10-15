package com.api.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.dto.SolicitudValidacionToken;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private String secret = "secret";

	RestTemplate clienteRest;

	UserDetails userdetails;

	@Autowired
	UserDetailsService userdetailservice;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {

	
		SecurityContextHolder.getContext().setAuthentication(null);
		
		try {

			String token = this.getToken(req);

			if (token != null && validateToken(token)) {

				String metodoHTTP = req.getMethod();

				String endpoint = req.getRequestURI();

				this.clienteRest = new RestTemplate();

				String UserNameJwtDto = this.getNombreUsuarioFromToken(token);

				SolicitudValidacionToken solicitud = new SolicitudValidacionToken(token, UserNameJwtDto, metodoHTTP,
						endpoint, "api");

				Boolean respuesta = clienteRest.postForObject("http://localhost:8081/auth/validaciontoken", solicitud,
						boolean.class);

				if (respuesta != null && respuesta == true) {

					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(null, null,
							null);
					SecurityContextHolder.getContext().setAuthentication(auth);
				}

			}
		} catch (Exception e) {

			logger.error("Falla en validacion");

			e.printStackTrace();

		}
		filterChain.doFilter(req, res);
	}

	private String getToken(HttpServletRequest request) {

		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer")) {

			return header.replace("Bearer ", "");
		}

		return null;

	}

	public boolean validateToken(String token) {

		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

			return true;

		} catch (MalformedJwtException e) {
			logger.error("token mal formado");
		} catch (UnsupportedJwtException e) {
			logger.error("token no soportado");
		} catch (ExpiredJwtException e) {
			logger.error("token expirado");
		} catch (IllegalArgumentException e) {
			logger.error("token vacio");
		} catch (SignatureException e) {
			logger.error("fail en la firma");
		}
		return false;
	}

	public String getNombreUsuarioFromToken(String token) {

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

}
