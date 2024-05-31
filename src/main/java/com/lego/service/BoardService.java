package com.lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lego.dto.Board;
import com.lego.mapper.BoardMapper;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Board> getBoardAll() {
        return boardMapper.getBoardAll();
    }

    public Board getOneBoard(int bno) {
        return boardMapper.getOneBoard(bno);
    }

    public void addBoard(Board board) {
        boardMapper.addBoard(board);
    }

    public void upBoard(Board board) {
        boardMapper.upBoard(board);
    }

    public void delBoard(int bno) {
        boardMapper.delBoard(bno);
    }

}
