package todo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.domain.BoardDTO;
import todo.mapper.BoardMapper;

//BoardMapper 인터페이스의 @Mapper과 유사, 해당 클래스가 비즈니스 로직을 담당하는 서비스 클래스임을 의미
//BoardService 인터페이스에 정의한 메서드를 정의하기 위해 상속 받음
@Service
public class BoardServicelmpl implements BoardService {
	
	//어노테이션으로 BoardMapper 인터페이스 빈을 주입
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;
		
		if (params.getIdx() == null) {
			queryResult = boardMapper.insertBoard(params);
		}else {
			queryResult = boardMapper.updateBoard(params);
		}
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public BoardDTO getBoardDetail(Long idx) {
		return boardMapper.selectBoardDetail(idx);
	}
	
	@Override
	public boolean deleteBoard(Long idx) {
		int queryResult = 0;
		
		BoardDTO board = boardMapper.selectBoardDetail(idx);
		
		if (board != null&& "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(idx);
		}
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public boolean updateView(Long idx) {
		int queryResult = 0;
		
		BoardDTO board = boardMapper.selectBoardDetail(idx);
		
		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.updateView(idx);
		}
		// TODO Auto-generated method stub
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public List<BoardDTO> getBoardList(){
		List<BoardDTO> boardList = Collections.emptyList();
		
		int boardTotalCount = boardMapper.selectBoardTotalCount();
		
		if(boardTotalCount>0) {
			boardList = boardMapper.selectBoardList();
		}
		
		return boardList;
	}
}
