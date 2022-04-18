package com.dung.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.dung.daoimp.SanPhamImp;
import com.dung.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanphamDao implements SanPhamImp{
	
	@Autowired
    SessionFactory mySessionFactory;
	@Transactional
	public List<SanPham> Laydanhsachsanpham() {
		// TODO Auto-generated method stub
		Session session=mySessionFactory.getCurrentSession();
		List<SanPham> sanphams= session.createQuery("from product").getResultList();
		return sanphams;
	}

}
