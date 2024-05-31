package com.lego.mapper;

import java.util.List;

import com.lego.dto.Board;

public interface BoardMapper {
	List<Board> getBoardAll();
    Board getOneBoard(int bno);
    void addBoard(Board board);
    void upBoard(Board board);
    void delBoard(int bno);
}