package com.dung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dung.dao.SanphamDao;
import com.dung.daoimp.SanPhamImp;
import com.dung.entity.SanPham;

@Service
public class SanPham_Service implements SanPhamImp{

	@Autowired 
	SanphamDao sanphamDao;
	public List<SanPham> Laydanhsachsanpham() {
		// TODO Auto-generated method stub
		return sanphamDao.Laydanhsachsanpham();
	}

}
