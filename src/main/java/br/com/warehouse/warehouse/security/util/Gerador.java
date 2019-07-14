package br.com.warehouse.warehouse.security.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Gerador {

	public static void main(String... args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("w@r3hous3"));
		System.out.println(bCryptPasswordEncoder.matches("@ngul4r", "$2a$10$zFi3T4nUThbYSzPbmvXx3e9V5sUxgzV8fJH4XTxcDzaHnynSYxbza"));
	}
	
}
