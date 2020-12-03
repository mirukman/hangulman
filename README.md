# 1. 소개 #
---

한글 자음/모음 분해 결합 및 한/영키 변환을 해주는 라이브러리입니다.

해당 라이브러리는 유니코드의 한글 표현 규칙을 응용하여 구현되었습니다.

규칙을 적용하였을뿐만 아니라 추가적인 휴리스틱을 이용해 'ㄳ', 'ㅄ', 'ㄾ' 등의 겹받침과 'ㅝ', 'ㅘ', 'ㅞ' 등의 이중모음도 분리할 수 있게 하였습니다.

겹받침과 이중모음을 분리할 것인지 선택할 수 있는 boolean 값을 메소드의 파라미터로 전달하여 원하는 방식을 선택할 수 있게 하였습니다.

<br>

# 2. 기능 #
---

### 1) 한글 자음/모음 분해결합 유틸 ###
---

*hangulman/src/main/java/com/mirukman/hangulman/utils/HangulCombinator.java*

<br>

`String decompose(String str, boolean delayer)` 메소드는 한글의 자음/모음 단위로 분리해주는 메소드입니다. delayer 값을 true로 하면 겹받침, 이중모음까지 깊은 분해가 이루어지고 false로 하면 겹받침, 이중모음은 그대로 두고 분해합니다.

`String compose(String str)` 메소드는 한글의 자음,모음 나열을 완전한 단어로 결합해주는 메소드입니다.

<br>

~~~ java
HangulCombinator hangulCombinator = new HangulCombinator();

hangulCombinator.decompose("밥값", true); //ㅂㅏㅂㄱㅏㅂㅅ
hangulCombinator.decompose("밥값", false); //ㅂㅏㅂㄱㅏㅄ

hangulCombinator.compose("ㅂㅏㅂㄱㅏㅂㅅ"); //밥값
hangulCombinator.compose("ㅂㅏㄴㄱㅏㅂㅅㅗ"); //반갑소

hangulCombinator.compose("ㄱㅐㄹㄹㅓㄱㅅㅣs10", true); //갤럭시s10
~~~

<br>

결합하거나 더 이상 분해할 수 없는 한글, 심지어 숫자나 영어, 특수문자등이 포함되어 있으면 해당 문자는 그대로 두고 가능한 범위까지만 처리하고 예외나 에러를 발생시키지 않아 실용성을 높였습니다.

<br>

### 2) 한/영키 변환 유틸 ###
---

*hangulman/src/main/java/com/mirukman/hangulman/utils/HangulEnglishKeyTransformer.java*

`String transformHangulToEnglish(String hangul)` 메소드는 한글을 자음/모음 단위까지 분리 후 키보드 상의 알파벳으로 변환시켜줍니다.

`String transformEnglishToHangul(String english)` 메소드는 영어를 한글 자음/모음으로 변환 후 결합하여 완전한 한글단어로 변환시켜줍니다.

<br>

~~~ java
HangulEnglishKeyTransformer keyTransformer = new HangulEnglishKeyTransformer();

keyTransformer.transformHangulToEnglish("한글맨"); //gksrmfaos
keyTransformer.transformEnglishToHangul("gksrmfaos"); //한글맨

keyTransformer.transformEnglishToHangul("tneh 25*13fpebti"); //수도 25*13레듀샤
keyTransformer.transformEnglishToHangul("ghaxortm\]"); // 홈택스\]
~~~

<br>

*hangulman/src/test/java/com/mirukman/hangulman/utils/* 패키지에 단위 테스트 클래스들을 작성해 놓았으므로 읽어보시면 유틸의 기능을 이해하는데 도움이 될 것입니다.