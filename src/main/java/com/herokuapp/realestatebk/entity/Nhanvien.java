package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the nhanvien database table.
 * 
 */
@Entity(name = "nhanvien")
@Table(name = "nhanvien")
public class Nhanvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int nvid;

	@Column(name = "diachi", nullable = false, length = 50)
	private String diachi;

	private float doanhthu;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false)
	private byte gioitinh;

	@Column(nullable = false, length = 50)
	private String matkhau;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date ngaysinh;

	@Column(nullable = false, length = 10)
	private String quyen;

	@Column(nullable = false)
	private int sdt;

	@Column(nullable = false, length = 20)
	private String taikhoan;

	@Column(nullable = false, length = 50)
	private String tennv;

	@Column(nullable = false)
	private byte trangthai;

	// bi-directional many-to-one association to Khachhang
	@OneToMany(mappedBy = "nhanvien", fetch = FetchType.EAGER)
	@JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Khachhang> khachhangs;

	public Nhanvien() {
	}

	public Nhanvien(String diachi, float doanhthu, String email, byte gioitinh, String matkhau, Date ngaysinh,
			String quyen, int sdt, String taikhoan, String tennv, byte trangthai) {
		super();
		this.diachi = diachi;
		this.doanhthu = doanhthu;
		this.email = email;
		this.gioitinh = gioitinh;
		this.matkhau = matkhau;
		this.ngaysinh = ngaysinh;
		this.quyen = quyen;
		this.sdt = sdt;
		this.taikhoan = taikhoan;
		this.tennv = tennv;
		this.trangthai = trangthai;
	}

	public Nhanvien(int nvid, String diachi, float doanhthu, String email, byte gioitinh, String matkhau, Date ngaysinh,
			String quyen, int sdt, String taikhoan, String tennv, byte trangthai) {
		super();
		this.nvid = nvid;
		this.diachi = diachi;
		this.doanhthu = doanhthu;
		this.email = email;
		this.gioitinh = gioitinh;
		this.matkhau = matkhau;
		this.ngaysinh = ngaysinh;
		this.quyen = quyen;
		this.sdt = sdt;
		this.taikhoan = taikhoan;
		this.tennv = tennv;
		this.trangthai = trangthai;
	}

	public int getNvid() {
		return this.nvid;
	}

	public void setNvid(int nvid) {
		this.nvid = nvid;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public float getDoanhthu() {
		return this.doanhthu;
	}

	public void setDoanhthu(float doanhthu) {
		this.doanhthu = doanhthu;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(byte gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getMatkhau() {
		return this.matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Date getNgaysinh() {
		return this.ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getQuyen() {
		return this.quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public int getSdt() {
		return this.sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getTennv() {
		return this.tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public byte getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public List<Khachhang> getKhachhangs() {
		return this.khachhangs;
	}

	public void setKhachhangs(List<Khachhang> khachhangs) {
		this.khachhangs = khachhangs;
	}

	public Khachhang addKhachhang(Khachhang khachhang) {
		getKhachhangs().add(khachhang);
		khachhang.setNhanvien(this);

		return khachhang;
	}

	public Khachhang removeKhachhang(Khachhang khachhang) {
		getKhachhangs().remove(khachhang);
		khachhang.setNhanvien(null);

		return khachhang;
	}
}