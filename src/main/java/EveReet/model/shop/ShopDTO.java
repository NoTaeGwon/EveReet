package EveReet.model.shop;

public class ShopDTO {
	
	private int prodnum;
	private String name;
	private String kind;
	private String brand;
	private	int price1;
	private int price2;
	private int price3;
	private String content;
	private String image;
	private String detail_image;
	private String thumb_image;
	private String useyn;
	private int quantity = 0;
	private int like;
	private String regdate;
	
	public ShopDTO() {
		super();
	}
	
	public ShopDTO(int prodnum, String name, String kind, String brand, int price1, int price2, int price3, String content, 
					String image, String detail_image, String thumb_image, int quantity, String useyn, int like, String regdate) {
		super();
		this.prodnum = prodnum;
		this.name = name;
		this.kind = kind;
		this.brand = brand;
		this.price1 = price1;
		this.price2 = price2;
		this.price3 = price3;
		this.content = content;
		this.image = image;
		this.detail_image = detail_image;
		this.thumb_image = thumb_image;
		this.useyn = useyn;
		this.quantity = quantity;
		this.like = like;
		this.regdate = regdate;
		
	}
	
	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getThumb_image() {
		return thumb_image;
	}

	public void setThumb_image(String thumb_image) {
		this.thumb_image = thumb_image;
	}

	public String getDetail_image() {
		return detail_image;
	}

	public void setDetail_image(String detail_image) {
		this.detail_image = detail_image;
	}

	public int getProdnum() {
		return prodnum;
	}

	public void setProdnum(int prodnum) {
		this.prodnum = prodnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}

	public int getPrice2() {
		return price2;
	}

	public void setPrice2(int price2) {
		this.price2 = price2;
	}

	public int getPrice3() {
		return price3;
	}

	public void setPrice3(int price3) {
		this.price3 = price3;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	
	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public void addQuantity() {
		this.quantity++;
	}
	
	@Override
	public String toString() {
		return "ShopDTO [prodnum=" + prodnum + ", name=" + name + ", kind=" + kind + ", brand=" + brand + ", price1="
				+ price1 + ", price2=" + price2 + ", price3=" + price3 + ", content=" + content + ", image=" + image
				+ ", detail_image=" + detail_image + ", thumb_image=" + thumb_image + ", useyn=" + useyn + ", like="
				+ like + ", regdate=" + regdate + "]";
	}
	

}
