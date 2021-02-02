package todo.service;

import java.util.List;
import todo.domain.BoardDTO;

public interface BoardService {
	public boolean registerBoard(BoardDTO params);
	public BoardDTO getBoardDetail(Long idx);
	public boolean deleteBoard(Long idx);
	public boolean updateView(Long idx);
	public List<BoardDTO> getBoardList();
}
