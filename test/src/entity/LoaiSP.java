package entity;

public class LoaiSP {
	private String maLoai;
	private String tenLoai;
	
	
	public LoaiSP(String maLoai) {
		super();
		this.maLoai = maLoai;
	}
	public LoaiSP(String maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public String getmaLoai() {
		return maLoai;
	}
	public void setmaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String gettenLoai() {
		return tenLoai;
	}
	public void settenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	@Override
	public String toString() {
		return "LoaiSP [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	
}
