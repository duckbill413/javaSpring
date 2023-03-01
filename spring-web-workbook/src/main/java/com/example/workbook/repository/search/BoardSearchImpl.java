package com.example.workbook.repository.search;

import com.example.workbook.domain.board.Board;
import com.example.workbook.domain.board.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

/**
 * author        : duckbill413
 * date          : 2023-02-25
 * description   :
 **/

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        // given
        QBoard board = QBoard.board; // Q도메인 객체
        JPQLQuery<Board> query = from(board); // select .. from board
        // where
        BooleanBuilder booleanBuilder = new BooleanBuilder(); //
        booleanBuilder.or(board.title.contains("11")); // title like
        booleanBuilder.or(board.content.contains("11"));

        query.where(booleanBuilder); // where title like ..
        query.where(board.bno.gt(0L));

        // paging
        this.getQuerydsl().applyPagination(pageable, query);

        // result
        List<Board> list = query.fetch();
        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        if ((types != null && types.length > 0) &&
                keyword != null) {// 검색 조건과 키워드가 있다면
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for (String type : types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            }
            // end for
            query.where(booleanBuilder);
        }// end if

        // bno > 0
        query.where(board.bno.gt(0L));
        // paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();
        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }
}