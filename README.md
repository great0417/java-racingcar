	/****

	핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
	MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.
	
	Model , View , Controller 의 합성어로 소프트웨어 공학에서 사용되는 소프트웨어 디자인 패턴입니다.
	Model(domain) : 백그라운드에서 동작하는 로직을 처리합니다.
	View : 사용자가 보게 될 결과 화면을 출력합니다.
	Controller : 사용자의 입력처리와 흐름 제어를 담당합니다.

	테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.
	
	**/
