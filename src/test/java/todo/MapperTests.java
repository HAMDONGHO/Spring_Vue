package todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import todo.domain.BoardDTO;
import todo.mapper.BoardMapper;

@SpringBootTest
class MapperTests {

	//어노테이션으로 BoardMapper 인터페이스 빈을 주입
	@Autowired
	private BoardMapper boardMapper;

	// BoardDTO를 생성하고 set메서드로 지정하 ㄴ뒤 insert 메서드로 params를 전달!
	@Test
	public void testOfInsert() {
		BoardDTO params = new BoardDTO();
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("테스터");

		int result = boardMapper.insertBoard(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	
	@Test
	public void testOfSelect() {
		BoardDTO board = boardMapper.selectBoardDetail((long) 1);
		try {
			//BoardDTO 객체 변수 board에 selectBoardDetail 메서드 결과 저장
			//board에 저장된 Jackson 라이브러리 이용해서 Json문자열로 변환해서 콘솔에 출력
			String boardJson = new ObjectMapper().writeValueAsString(board);
			
			System.out.println("======================");
			System.out.println(boardJson);
			System.out.println("======================");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	@Test
	public void testOfUpdate() {
		BoardDTO params = new BoardDTO();
		params.setTitle("1번 게시글 제목 수정");
		params.setContent("1번 게시글 수정");
		params.setWriter("함도호");
		params.setIdx((long) 1);
		
		int result = boardMapper.updateBoard(params);
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long) 1);
			try {
				String boardJson = new ObjectMapper().writeValueAsString(board);
				System.out.println("======================");
				System.out.println(boardJson);
				System.out.println("======================");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}	
	}
	
	@Test
	public void testOfdelete() {
		BoardDTO params = new BoardDTO();
		params.setIdx((long) 1);
		
		int result = boardMapper.deleteBoard((long) 1);
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long) 1);
			try {
				String boardJson = new ObjectMapper().writeValueAsString(board);
				System.out.println("======================");
				System.out.println(boardJson);
				System.out.println("======================");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}	
	}
}