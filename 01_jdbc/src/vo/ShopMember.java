package vo;

public class ShopMember {
	private String memberId;
	private String memberPw;
	private String phone;
	private char gender;
	
	public ShopMember() {}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ShopMember [memberId=" + memberId + ", memberPw=" + memberPw +
			   ", phone=" + phone + ", gender=" + gender + "]";
	}
}