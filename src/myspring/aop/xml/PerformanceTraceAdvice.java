package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�� �޼����� signature ����
		String signatureString = joinPoint.getSignature().toShortString();		
		System.out.println(signatureString + " 시작");
		//Ÿ���� �޼��尡 ȣ��Ǳ� ���� �ð� 
		long start = System.currentTimeMillis();		
		try {
			//new Object[] {new String("dooly")}
			//Ÿ���� �޼��� ȣ��
			Object result = joinPoint.proceed(); //반듯이 proceed()를 호출해야 한다.
			return result;
	
		} finally {
			//Ÿ���� �޼��尡 ȣ��� ���� �ð�
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행시간 : " + 
			   (finish - start) + " ms");
		}
	}
}
