package album.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class AlbumBean {
	
	private int num;
	
	@NotEmpty(message = "제목 누락")
	private String title;
	
	@NotEmpty(message = "가수명 누락")
	@Size(min = 3, max = 7, message = "size 3~7자리 입력해주세요")
	//@Length(min = 3, max = 7, message = "@Length 3~7자리 입력해주세요")
	private String singer;
	
	@NotEmpty(message = "가격 누락")
	@Min(value=1000, message = "최소 1000원 이상 입력해주세요")
	private String price;
	
	private String day;
	
	public AlbumBean() {
		
	}
	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
}