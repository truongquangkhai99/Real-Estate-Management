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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the khachhang database table.
 * 
 */
@Entity(name = "khachhang")
@Table(name = "khachhang")
public class Khachhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int khid;

	@Column(nullable = false)
	private int cmnd;

	@Column(nullable = false, length = 50)
	private String diachi;

	@Column(nullable = false, length = 50)
	private String diachitt;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false)
	private byte gioitinh;

	@Column(nullable = false, length = 50)
	private String hoten;

	@Column(nullable = false)
	private byte loaikh;

	@Column(length = 300)
	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date ngaysinh;

	@Column(nullable = false)
	private int sodienthoai;

	@Column(nullable = false)
	private byte trangthai;

	// bi-directional many-to-one association to Batdongsan
	@OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Batdongsan> batdongsans;

	// bi-directional many-to-one association to Hopdongchuyennhuong
	@OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Hopdongchuyennhuong> hopdongchuyennhuongs;

	// bi-directional many-to-one association to Hopdongdatcoc
	@OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Hopdongdatcoc> hopdongdatcocs;

	// bi-directional many-to-one association to Hopdongkygui
	@OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Hopdongkygui> hopdongkyguis;

	// bi-directional many-to-one association to Nhanvien
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nvid")
	@JsonIgnore
	private Nhanvien nhanvien;

	// bi-directional many-to-one association to Yeucaukhachhang
	@OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Yeucaukhachhang> yeucaukhachhangs;

	public Khachhang() {
	}
	
	public Khachhang(int khid, int cmnd, String diachi, String diachitt, String email, byte gioitinh, String hoten,
			byte loaikh, String mota, Date ngaysinh, int sodienthoai, byte trangthai) {
		super();
		this.khid = khid;
		this.cmnd = cmnd;
		this.diachi = diachi;
		this.diachitt = diachitt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.hoten = hoten;
		this.loaikh = loaikh;
		this.mota = mota;
		this.ngaysinh = ngaysinh;
		this.sodienthoai = sodienthoai;
		this.trangthai = trangthai;
		this.batdongsans = null;
		this.hopdongchuyennhuongs = null;
		this.hopdongdatcocs = null;
		this.hopdongkyguis = null;
		this.nhanvien = null;
		this.yeucaukhachhangs = null;
	}
	
	public Khachhang( int cmnd, String diachi, String diachitt, String email, byte gioitinh, String hoten,
			byte loaikh, String mota, Date ngaysinh, int sodienthoai, byte trangthai) {
		super();
		this.cmnd = cmnd;
		this.diachi = diachi;
		this.diachitt = diachitt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.hoten = hoten;
		this.loaikh = loaikh;
		this.mota = mota;
		this.ngaysinh = ngaysinh;
		this.sodienthoai = sodienthoai;
		this.trangthai = trangthai;
		this.batdongsans = null;
		this.hopdongchuyennhuongs = null;
		this.hopdongdatcocs = null;
		this.hopdongkyguis = null;
		this.nhanvien = null;
		this.yeucaukhachhangs = null;
	}


	public Khachhang(int khid, int cmnd, String diachi, String diachitt, String email, byte gioitinh, String hoten,
			byte loaikh, String mota, Date ngaysinh, int sodienthoai, byte trangthai, List<Batdongsan> batdongsans,
			List<Hopdongchuyennhuong> hopdongchuyennhuongs, List<Hopdongdatcoc> hopdongdatcocs,
			List<Hopdongkygui> hopdongkyguis, Nhanvien nhanvien, List<Yeucaukhachhang> yeucaukhachhangs) {
		super();
		this.khid = khid;
		this.cmnd = cmnd;
		this.diachi = diachi;
		this.diachitt = diachitt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.hoten = hoten;
		this.loaikh = loaikh;
		this.mota = mota;
		this.ngaysinh = ngaysinh;
		this.sodienthoai = sodienthoai;
		this.trangthai = trangthai;
		this.batdongsans = batdongsans;
		this.hopdongchuyennhuongs = hopdongchuyennhuongs;
		this.hopdongdatcocs = hopdongdatcocs;
		this.hopdongkyguis = hopdongkyguis;
		this.nhanvien = nhanvien;
		this.yeucaukhachhangs = yeucaukhachhangs;
	}



	public int getKhid() {
		return this.khid;
	}

	public void setKhid(int khid) {
		this.khid = khid;
	}

	public int getCmnd() {
		return this.cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getDiachitt() {
		return this.diachitt;
	}

	public void setDiachitt(String diachitt) {
		this.diachitt = diachitt;
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

	public String getHoten() {
		return this.hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public byte getLoaikh() {
		return this.loaikh;
	}

	public void setLoaikh(byte loaikh) {
		this.loaikh = loaikh;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getNgaysinh() {
		return this.ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public int getSodienthoai() {
		return this.sodienthoai;
	}

	public void setSodienthoai(int sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public byte getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public List<Batdongsan> getBatdongsans() {
		return this.batdongsans;
	}

	public void setBatdongsans(List<Batdongsan> batdongsans) {
		this.batdongsans = batdongsans;
	}

	public Batdongsan addBatdongsan(Batdongsan batdongsan) {
		getBatdongsans().add(batdongsan);
		batdongsan.setKhachhang(this);

		return batdongsan;
	}

	public Batdongsan removeBatdongsan(Batdongsan batdongsan) {
		getBatdongsans().remove(batdongsan);
		batdongsan.setKhachhang(null);

		return batdongsan;
	}

	public List<Hopdongchuyennhuong> getHopdongchuyennhuongs() {
		return this.hopdongchuyennhuongs;
	}

	public void setHopdongchuyennhuongs(List<Hopdongchuyennhuong> hopdongchuyennhuongs) {
		this.hopdongchuyennhuongs = hopdongchuyennhuongs;
	}

	public Hopdongchuyennhuong addHopdongchuyennhuong(Hopdongchuyennhuong hopdongchuyennhuong) {
		getHopdongchuyennhuongs().add(hopdongchuyennhuong);
		hopdongchuyennhuong.setKhachhang(this);

		return hopdongchuyennhuong;
	}

	public Hopdongchuyennhuong removeHopdongchuyennhuong(Hopdongchuyennhuong hopdongchuyennhuong) {
		getHopdongchuyennhuongs().remove(hopdongchuyennhuong);
		hopdongchuyennhuong.setKhachhang(null);

		return hopdongchuyennhuong;
	}

	public List<Hopdongdatcoc> getHopdongdatcocs() {
		return this.hopdongdatcocs;
	}

	public void setHopdongdatcocs(List<Hopdongdatcoc> hopdongdatcocs) {
		this.hopdongdatcocs = hopdongdatcocs;
	}

	public Hopdongdatcoc addHopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		getHopdongdatcocs().add(hopdongdatcoc);
		hopdongdatcoc.setKhachhang(this);

		return hopdongdatcoc;
	}

	public Hopdongdatcoc removeHopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		getHopdongdatcocs().remove(hopdongdatcoc);
		hopdongdatcoc.setKhachhang(null);

		return hopdongdatcoc;
	}

	public List<Hopdongkygui> getHopdongkyguis() {
		return this.hopdongkyguis;
	}

	public void setHopdongkyguis(List<Hopdongkygui> hopdongkyguis) {
		this.hopdongkyguis = hopdongkyguis;
	}

	public Hopdongkygui addHopdongkygui(Hopdongkygui hopdongkygui) {
		getHopdongkyguis().add(hopdongkygui);
		hopdongkygui.setKhachhang(this);

		return hopdongkygui;
	}

	public Hopdongkygui removeHopdongkygui(Hopdongkygui hopdongkygui) {
		getHopdongkyguis().remove(hopdongkygui);
		hopdongkygui.setKhachhang(null);

		return hopdongkygui;
	}

	public Nhanvien getNhanvien() {
		return this.nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public List<Yeucaukhachhang> getYeucaukhachhangs() {
		return this.yeucaukhachhangs;
	}

	public void setYeucaukhachhangs(List<Yeucaukhachhang> yeucaukhachhangs) {
		this.yeucaukhachhangs = yeucaukhachhangs;
	}

	public Yeucaukhachhang addYeucaukhachhang(Yeucaukhachhang yeucaukhachhang) {
		getYeucaukhachhangs().add(yeucaukhachhang);
		yeucaukhachhang.setKhachhang(this);

		return yeucaukhachhang;
	}

	public Yeucaukhachhang removeYeucaukhachhang(Yeucaukhachhang yeucaukhachhang) {
		getYeucaukhachhangs().remove(yeucaukhachhang);
		yeucaukhachhang.setKhachhang(null);

		return yeucaukhachhang;
	}

}