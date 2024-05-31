package com.lego.mapper;

import java.util.List;

import com.lego.dto.Member;

public interface MemberMapper {
	
	public List<Member> getMemberList();
	public Member getMember(String id);
	public int memberCount();
	public void insMember(Member member);
	public void changePw(Member member);
	public void changeInfo(Member member);
	public void changePoint(Member member);
	public void delMember(String id);

}
