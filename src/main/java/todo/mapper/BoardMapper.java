package todo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import todo.domain.BoardDTO;

//mybatis에서는 mapper만 지정해주면 xmlmapper에서 메서드의 이름과 일치하는 sql문을 찾아 실행
@Mapper
public interface BoardMapper {
	public int insertBoard(BoardDTO params);

	public BoardDTO selectBoardDetail(Long idx);

	public int updateBoard(BoardDTO params);
	
	public int updateView(Long idx);

	public int deleteBoard(Long idx);

	public List<BoardDTO> selectBoardList();

	public int selectBoardTotalCount();

}
