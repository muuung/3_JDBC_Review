package view;

import dao.ShopDAO;
import vo.ShopMember;

public class ShopView {
	ShopMember sm = new ShopMember();
	ShopDAO sd = new ShopDAO();
	
	public void view() {
		sm = null;
		String memberId = "user01";
		
		sm = sd.searchUser(memberId);
		
		if(sm != null) System.out.println(sm);
		else 		   System.out.println("조회 결과가 없습니다.");
	}
}