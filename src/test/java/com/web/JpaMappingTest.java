package com.web;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.domain.enums.BoardType;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * @author : taeyoung
 * @since : 2018-12
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
    private final String boardTestTitle = "테스트";
    private final String email = "test@gmial.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before
    public void init() {
        User user = userRepository.save(User.builder()
        .name("taeyoung")
        .password("password")
        .email(email)
        .createDate(LocalDateTime.now())
        .build());

        boardRepository.save(Board.builder()
        .title(boardTestTitle)
        .subTitle("서브타이틀")
        .content("콘텐츠")
        .boardType(BoardType.free)
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .user(user)
        .build());
    }

    @Test
    public void check () {
        User user = userRepository.findByEmail(email);
        assertThat(user.getName(), is("taeyoung"));
        assertThat(user.getPassword(), is("password"));
        assertThat(user.getEmail(), is(email));

        Board board = boardRepository.findByUser(user);
        assertThat(board.getTitle(), is(boardTestTitle));
        assertThat(board.getSubTitle(), is("서브타이틀"));
        assertThat(board.getContent(), is("콘텐츠"));
        assertThat(board.getBoardType(), is(BoardType.free  ));
    }

}
