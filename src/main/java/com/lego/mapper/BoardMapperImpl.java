package com.lego.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lego.dto.Board;

@Repository
public class BoardMapperImpl implements BoardMapper {

    private final SqlSession sqlSession;

    @Autowired
    public BoardMapperImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Board> getBoardAll() {
        return sqlSession.selectList("com.lego.mapper.BoardMapper.getBoardAll");
    }

    @Override
    public Board getOneBoard(int bno) {
        return sqlSession.selectOne("com.lego.mapper.BoardMapper.getOneBoard", bno);
    }

    @Override
    public void addBoard(Board board) {
        sqlSession.insert("com.lego.mapper.BoardMapper.addBoard", board);
    }

    @Override
    public void upBoard(Board board) {
        sqlSession.update("com.lego.mapper.BoardMapper.upBoard", board);
    }

    @Override
    public void delBoard(int bno) {
        sqlSession.delete("com.lego.mapper.BoardMapper.delBoard", bno);
    }
}