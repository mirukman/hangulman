package com.mirukman.hangulman.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {HangulCombinator.class})
public class HangulCombinatorTest {

    HangulCombinator hangulCombinator = new HangulCombinator();

    @Test
    public void decomposeTest() {

        //노멀
        assertEquals("ㄱㅏㄴㅏㄷㅏㄹㅏ", hangulCombinator.decompose("가나다라", true));
        assertEquals("ㄱㅏㄴㅏㄷㅏㄹㅏ", hangulCombinator.decompose("가나다라", false));
        assertEquals("ㅎㅏㄴㄱㅡㄹㅁㅐㄴ", hangulCombinator.decompose("한글맨", true));
        assertEquals("ㅎㅏㄴㄱㅡㄹㅁㅐㄴ", hangulCombinator.decompose("한글맨", false));
        assertEquals("ㄱㅣㅇㅓㅂㅇㅡㄴㅐㅎㅇ", hangulCombinator.decompose("기업으냏ㅇ", true));
        assertEquals("ㄱㅣㅇㅓㅂㅇㅡㄴㅐㅎㅇ", hangulCombinator.decompose("기업으냏ㅇ", false));
        assertEquals("ㅅㅣㄴㅅㅔㄱㅖ", hangulCombinator.decompose("신세계", true));
        assertEquals("ㅅㅣㄴㅅㅔㄱㅖ", hangulCombinator.decompose("신세계", false));
        assertEquals("ㄴㅏㄲㅅㅣㅇㅛㅇㅍㅜㅁ", hangulCombinator.decompose("낚시용품", true));
        assertEquals("ㄴㅏㄲㅅㅣㅇㅛㅇㅍㅜㅁ", hangulCombinator.decompose("낚시용품", false));

        //띄어쓰기
        assertEquals("ㅎㅏㄴ ㄱㅡㄹㅁㅐㄴ", hangulCombinator.decompose("한 글맨", true));
        assertEquals("ㅎㅏㄴ ㄱㅡㄹㅁㅐㄴ", hangulCombinator.decompose("한 글맨", false));
        assertEquals("ㅎㅏ ㄴㄱㅡㄹㅁㅐㄴ", hangulCombinator.decompose("하 ㄴ글맨", true));
        assertEquals("ㅎㅏ ㄴㄱㅡㄹㅁㅐㄴ", hangulCombinator.decompose("하 ㄴ글맨", false));
        assertEquals("ㅈㅔㄴㅔㅅㅣㅅㅡ ㅋㅜㅍㅔ ㅅㅣㅈㅓㄷㅗㅇㅓ",
                hangulCombinator.decompose("제네시스 쿠페 시저도어", true));
        assertEquals("ㅈㅔㄴㅔㅅㅣㅅㅡ ㅋㅜㅍㅔ ㅅㅣㅈㅓㄷㅗㅇㅓ",
                hangulCombinator.decompose("제네시스 쿠페 시저도어", false));
        assertEquals(" ㅎㅏㄴ ㄱㅡㄹ ㅁㅐㄴ ", hangulCombinator.decompose(" 한 글 맨 ", true));
        assertEquals(" ㅎㅏㄴ ㄱㅡㄹ ㅁㅐㄴ ", hangulCombinator.decompose(" 한 글 맨 ", false));


        //이중모음
        assertEquals("ㅇㅜㅓㄴㅈㅜㄴㅗㅇㅎㅕㅂ", hangulCombinator.decompose("원주농협", true));
        assertEquals("ㅇㅝㄴㅈㅜㄴㅗㅇㅎㅕㅂ", hangulCombinator.decompose("원주농협", false));
        assertEquals("ㅇㅜㅔㅂㅎㅏㄷㅡ", hangulCombinator.decompose("웹하드", true));
        assertEquals("ㅇㅞㅂㅎㅏㄷㅡ", hangulCombinator.decompose("웹하드", false));
        assertEquals("ㅜㅓㄴㅈㅜㄴㅗㅇㅎㅕㅂ", hangulCombinator.decompose("ㅝㄴ주농협", true));
        assertEquals("ㅝㄴㅈㅜㄴㅗㅇㅎㅕㅂ", hangulCombinator.decompose("ㅝㄴ주농협", false));

        //겹받침
        assertEquals("ㄱㅏㅂㅅㅇㅓㅊㅣ", hangulCombinator.decompose("값어치", true));
        assertEquals("ㄱㅏㅄㅇㅓㅊㅣ", hangulCombinator.decompose("값어치", false));

        assertEquals("ㄱㅕㅇㄱㅣㄱㅏㅇㅏㄴㅎㅈㅗㅎㄷㅏ",
                hangulCombinator.decompose("경기가않좋다", true));
        assertEquals("ㄱㅕㅇㄱㅣㄱㅏㅇㅏㄶㅈㅗㅎㄷㅏ",
                hangulCombinator.decompose("경기가않좋다", false));

        //이중모음 + 겹받침
        assertEquals("ㅇㅜㅓㄴㅈㄴㅗㅇㅎㅕㅂ", hangulCombinator.decompose("웑농협", true));
        assertEquals("ㅇㅝㄵㄴㅗㅇㅎㅕㅂ", hangulCombinator.decompose("웑농협", false));

        //영어포함
        assertEquals("wjdtkddjgkrdnjs", hangulCombinator.decompose("wjdtkddjgkrdnjs", true));
        assertEquals("wjdtkddjgkrdnjs", hangulCombinator.decompose("wjdtkddjgkrdnjs", false));
        assertEquals("dnlenfkd", hangulCombinator.decompose("dnlenfkd", true));
        assertEquals("dnlenfkd", hangulCombinator.decompose("dnlenfkd", false));
        assertEquals("benzyi chloride", hangulCombinator.decompose("benzyi chloride", true));
        assertEquals("benzyi chloride", hangulCombinator.decompose("benzyi chloride", false));

        //특수 기호
        assertEquals("ㅅㅜㄷㅗ 25*13fpebti", hangulCombinator.decompose("수도 25*13fpebti", true));
        assertEquals("ㅅㅜㄷㅗ 25*13fpebti", hangulCombinator.decompose("수도 25*13fpebti", false));
        assertEquals("ㅡㅠㅊalsl", hangulCombinator.decompose("ㅡㅠㅊalsl", true));
        assertEquals("ㅡㅠㅊalsl", hangulCombinator.decompose("ㅡㅠㅊalsl", false));
        assertEquals("ㅎㅗㅁㅌㅐㄱㅅㅡ\\", hangulCombinator.decompose("홈택스\\", true));
        assertEquals("ㅎㅗㅁㅌㅐㄱㅅㅡ\\", hangulCombinator.decompose("홈택스\\", false));
        assertEquals("ㄴ[ㅇ;ㅂㅏ", hangulCombinator.decompose("ㄴ[ㅇ;바", true));
        assertEquals("ㄴ[ㅇ;ㅂㅏ", hangulCombinator.decompose("ㄴ[ㅇ;바", false));
        assertEquals("ㅋㅜㅍㅏㅇㅂㅗㅅㅏㅇ.com", hangulCombinator.decompose("쿠팡보상.com", true));
        assertEquals("ㅋㅜㅍㅏㅇㅂㅗㅅㅏㅇ.com", hangulCombinator.decompose("쿠팡보상.com", false));

        //띄어쓰기 + 겹받침
        assertEquals("ㄱㅏㅂ ㅅㅇㅓㅊㅣ", hangulCombinator.decompose("갑 ㅅ어치", true));
        assertEquals("ㄱㅏㅂ ㅅㅇㅓㅊㅣ", hangulCombinator.decompose("갑 ㅅ어치", false));
        assertEquals("ㄱㅏㅂㅅㅇ ㅓㅊㅣ", hangulCombinator.decompose("값ㅇ ㅓ치", true));
        assertEquals("ㄱㅏㅄㅇ ㅓㅊㅣ", hangulCombinator.decompose("값ㅇ ㅓ치", false));
        assertEquals("ㄱㅏㅂㅅㅇㅓㅊㅣ", hangulCombinator.decompose("값엋ㅣ", true));
        assertEquals("ㄱㅏㅄㅇㅓㅊㅣ", hangulCombinator.decompose("값엋ㅣ", false));
        assertEquals("ㄱㅏ ㅂㅅㅇㅓㅊㅣ", hangulCombinator.decompose("가 ㅂㅅ어치", true));
        assertEquals("ㄱㅏ ㅂㅅㅇㅓㅊㅣ", hangulCombinator.decompose("가 ㅂㅅ어치", false));
        assertEquals("ㄱㅏㅂㅅㅇ ㅓㅊ ㅣ", hangulCombinator.decompose("가ㅂㅅㅇ ㅓㅊ ㅣ", true));
        assertEquals("ㄱㅏㅂㅅㅇ ㅓㅊ ㅣ", hangulCombinator.decompose("가ㅂㅅㅇ ㅓㅊ ㅣ", false));
    }

    @Test
    public void composeTest() {

        //노멀
        assertEquals("가나다라", hangulCombinator.compose("ㄱㅏㄴㅏㄷㅏㄹㅏ"));
        assertEquals("한글맨", hangulCombinator.compose("ㅎㅏㄴㄱㅡㄹㅁㅐㄴ"));
        assertEquals("기업으냏ㅇ", hangulCombinator.compose("ㄱㅣㅇㅓㅂㅇㅡㄴㅐㅎㅇ"));

        //띄어쓰기
        assertEquals("한 글맨", hangulCombinator.compose("ㅎㅏㄴ ㄱㅡㄹㅁㅐㄴ"));
        assertEquals("하 ㄴ글맨", hangulCombinator.compose("ㅎㅏ ㄴㄱㅡㄹㅁㅐㄴ"));
        assertEquals("제네시스 쿠페 시저도어",
                hangulCombinator.compose("ㅈㅔㄴㅔㅅㅣㅅㅡ ㅋㅜㅍㅔ ㅅㅣㅈㅓㄷㅗㅇㅓ"));

        //이중모음
        assertEquals("유롸리그", hangulCombinator.compose("ㅇㅠㄹㅗㅏㄹㅣㄱㅡ"));
        assertEquals("원주농협", hangulCombinator.compose("ㅇㅜㅓㄴㅈㅜㄴㅗㅇㅎㅕㅂ"));
        assertEquals("웹하드", hangulCombinator.compose("ㅇㅜㅔㅂㅎㅏㄷㅡ"));
        assertEquals("ㅝㄴ주농협", hangulCombinator.compose("ㅜㅓㄴㅈㅜㄴㅗㅇㅎㅕㅂ"));

        //겹받침
        assertEquals("값어치", hangulCombinator.compose("ㄱㅏㅂㅅㅇㅓㅊㅣ"));
        assertEquals("시름시름앓으면", hangulCombinator.compose("ㅅㅣㄹㅡㅁㅅㅣㄹㅡㅁㅇㅏㄹㅎㅇㅡㅁㅕㄴ"));

        //이중모음 + 겹받침
        assertEquals("웑농협", hangulCombinator.compose("ㅇㅜㅓㄴㅈㄴㅗㅇㅎㅕㅂ"));

        //영어포함
        assertEquals("wjdtkddjgkrdnjs", hangulCombinator.compose("wjdtkddjgkrdnjs"));
        assertEquals("dnlenfkd", hangulCombinator.compose("dnlenfkd"));
        assertEquals("benzyi chloride", hangulCombinator.compose("benzyi chloride"));

        //특수 기호
        assertEquals("수도 25*13fpebti", hangulCombinator.compose("ㅅㅜㄷㅗ 25*13fpebti"));
        assertEquals("ㅡㅠㅊalsl", hangulCombinator.compose("ㅡㅠㅊalsl"));
        assertEquals("홈택스\\", hangulCombinator.compose("ㅎㅗㅁㅌㅐㄱㅅㅡ\\"));
        assertEquals("ㄴ[ㅇ;바", hangulCombinator.compose("ㄴ[ㅇ;ㅂㅏ"));
        assertEquals("쿠팡보상.채ㅡ", hangulCombinator.compose("ㅋㅜㅍㅏㅇㅂㅗㅅㅏㅇ.ㅊㅐㅡ"));

        //띄어쓰기 + 겹받침
        assertEquals("갑 ㅅ어치", hangulCombinator.compose("ㄱㅏㅂ ㅅㅇㅓㅊㅣ"));
        assertEquals("값ㅇ ㅓ치", hangulCombinator.compose("ㄱㅏㅂㅅㅇ ㅓㅊㅣ"));
        assertEquals("값어치", hangulCombinator.compose("ㄱㅏㅂㅅㅇㅓㅊㅣ"));
        assertEquals("가 ㅂㅅ어치", hangulCombinator.compose("ㄱㅏ ㅂㅅㅇㅓㅊㅣ"));
    }

    
}