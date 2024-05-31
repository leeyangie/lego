package com.lego.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lego.dto.Member;

@Repository
public class MemberMapperImpl implements MemberMapper {
	
	private final SqlSession sqlSession;
	
	@Autowired
    public MemberMapperImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Member> getMemberList() {
		return sqlSession.selectList("com.lego.mapper.MemberMapper.getMemberList");
	}

	@Override
	public Member getMember(String id) {
	    return sqlSession.selectOne("com.lego.mapper.MemberMapper.getMember", id);
	}

	@Override
	public int memberCount() {		
		return sqlSession.selectOne("com.lego.mapper.MemberMapper.memberCount");
	}

	@Override
	public void insMember(Member member) {
		sqlSession.insert("com.lego.mapper.MemberMapper.insMember", member);
	}

	@Override
	public void changePw(Member member) {
		sqlSession.update("com.lego.mapper.MemberMapper.changePw", member);	
	}

	@Override
	public void changeInfo(Member member) {
		sqlSession.update("com.lego.mapper.MemberMapper.changeInfo", member);
	}

	@Override
	public void changePoint(Member member) {
		sqlSession.update("com.lego.mapper.MemberMapper.changePoint", member);	
	}

	@Override
	public void delMember(String id) {
		sqlSession.delete("com.lego.mapper.MemberMapper.delMember", id);
	}
	
}