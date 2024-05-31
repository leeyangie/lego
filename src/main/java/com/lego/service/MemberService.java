package com.lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lego.dto.Member;
import com.lego.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public List<Member> getMemberList() {
		return memberMapper.getMemberList();
	}

	public Member getMember(String id) {
		return memberMapper.getMember(id);
	}

	public int memberCount() {
		return memberMapper.memberCount();
	}

	public void insMember(Member member) {
		memberMapper.insMember(member);
	}

	public void changePw(Member member) {
		memberMapper.changePw(member);
	}

	public void changeInfo(Member member) {
		memberMapper.changeInfo(member);
	}

	public void changePoint(Member member) {
		memberMapper.changePoint(member);
	}

	public void delMember(String id) {
		memberMapper.delMember(id);
	}
}