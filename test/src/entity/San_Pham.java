package entity;

public class San_Pham {
	private String maSP;
	private String tenSP;
	private int donGia;
	private String size;
//	private LoaiSP loaiSP;
	private String image;
	private String maLoai;
	public San_Pham() {
		super();
	}

	public San_Pham(String maSP, String tenSP, int donGia, String size,String image,String maLoai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.size = size;
		this.image = image;
		this.maLoai = maLoai;
		
	}
	
	public San_Pham(String maSP) {
		super();
		this.maSP = maSP;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	

	
}

