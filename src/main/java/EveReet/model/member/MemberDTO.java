package EveReet.model.member;

public class MemberDTO {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String zip_code;
	private String address;
	private String phone;
	private int useyn;
	private String regdate;
	
//	private String code_categoryname;
//	private String code_categorycode;
//	private String code_countryname;
//	private String code_countrycode;
	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String id, String pwd, String name, String email, String zip_code, String address,
			String phone, int useyn, String regdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.zip_code = zip_code;
		this.address = address;
		this.phone = phone;
		this.useyn = useyn;
		this.regdate = regdate;
		
//		this.code_categoryname = code_categoryname;
//		this.code_categorycode = code_categorycode;
//		this.code_countryname = code_countryname;
//		this.code_countrycode = code_countrycode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUseyn() {
		return useyn;
	}

	public void setUseyn(int useyn) {
		this.useyn = useyn;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
//	public String getCode_categoryname() {
//		return code_categoryname;
//	}
//
//	public void setCode_categoryname(String code_categoryname) {
//		this.code_categoryname = code_categoryname;
//	}
//
//	public String getCode_categorycode() {
//		return code_categorycode;
//	}
//
//	public void setCode_categorycode(String code_categorycode) {
//		this.code_categorycode = code_categorycode;
//	}
//
//	public String getCode_countryname() {
//		return code_countryname;
//	}
//
//	public void setCode_countryname(String code_countryname) {
//		this.code_countryname = code_countryname;
//	}
//
//	public String getCode_countrycode() {
//		return code_countrycode;
//	}
//
//	public void setCode_countrycode(String code_countrycode) {
//		this.code_countrycode = code_countrycode;
//	}
	

}
