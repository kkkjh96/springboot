package com.study.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.board.entity.Board;
import com.study.board.entity.BoardRepository;

@SpringBootTest
public class BoardTests {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	void save() {
		
		//1. �Խñ� �Ķ���� ����
		Board params = Board.builder()
				.title("1�� �Խñ� ����")
				.content("1�� �Խñ� ����")
				.writer("ȫ�浿")
				.hits(0)
				.deleteYn('N')
				.build();
		
		//2. �Խñ� ����
		boardRepository.save(params);
		
		//3. 1�� �Խñ� ���� ��ȸ
		Board entity = boardRepository.findById((long) 1).get();
		assertThat(entity.getTitle()).isEqualTo("1�� �Խñ� ����");
		assertThat(entity.getContent()).isEqualTo("1�� �Խñ� ����");
		assertThat(entity.getWriter()).isEqualTo("ȫ�浿");
	}
	
	@Test
    void findAll() {

        // 1. ��ü �Խñ� �� ��ȸ
        long boardsCount = boardRepository.count();

        // 2. ��ü �Խñ� ����Ʈ ��ȸ
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {

        // 1. �Խñ� ��ȸ
        Board entity = boardRepository.findById((long) 1).get();

        // 2. �Խñ� ����
        boardRepository.delete(entity);
    }
}
