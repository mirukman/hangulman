package com.mirukman.hangulman;

import java.io.IOException;

import com.mirukman.hangulman.utils.HangulCombinator;
import com.mirukman.hangulman.utils.HangulEnglishKeyTransformer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(Application.class);

		HangulCombinator hangulCombinator = new HangulCombinator();
		HangulEnglishKeyTransformer keyTransformer = new HangulEnglishKeyTransformer();

		System.out.println(hangulCombinator.decompose("밥값", true)); //ㅂㅏㅂㄱㅏㅂㅅ
		System.out.println(hangulCombinator.decompose("밥값", false)); //ㅂㅏㅂㄱㅏㅄ

		System.out.println(hangulCombinator.compose("ㅂㅏㅂㄱㅏㅂㅅ")); //밥값
		System.out.println(hangulCombinator.compose("ㅂㅏㄴㄱㅏㅂㅅㅗ")); //반갑소

		System.out.println(keyTransformer.transformHangulToEnglish("한글맨")); //gksrmfaos
		System.out.println(keyTransformer.transformEnglishToHangul("gksrmfaos")); //한글맨
	}
}
