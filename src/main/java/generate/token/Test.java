package generate.token;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Test {

	public static void main(String[] args) {

		String key = "SBM";
		String token = Jwts.builder().setId("Id123").setSubject("Talib").setIssuer("Muhammad")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes())).compact();

		System.out.println(token);

		Claims body = Jwts.parser().setSigningKey(Base64.getEncoder().encode(key.getBytes())).parseClaimsJws(token)
				.getBody();
		
		System.out.println(body.getSubject());
		System.out.println(body.getId());
		System.out.println(body.getIssuer());
		System.out.println(body.getExpiration());
	}

}
