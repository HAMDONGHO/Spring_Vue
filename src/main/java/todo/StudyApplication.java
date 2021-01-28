package todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudyApplication {
	
	//main 메서드가 springapplication.run  메서드를 호출헤서 웹 어플리케이션 실행하는 역할
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
