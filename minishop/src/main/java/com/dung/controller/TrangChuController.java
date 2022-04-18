package com.dung.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dung.dao.SanphamDao;
import com.dung.entity.NhanVien;
import com.dung.entity.SanPham;
import com.dung.entity.database_jdbc;

import com.dung.entity.HelloWorld;
import com.dung.service.SanPham_Service;

@Controller
public class TrangChuController {
	@Autowired
	SanPham_Service sanPham_Service;
	@RequestMapping("/")
	public String login()
	{
//		ApplicationContext context=new ClassPathXmlApplicationContext("IoC.xml");
//		database_jdbc data=(database_jdbc) context.getBean("jdbc");
//		data.getnv();
//		Session session=mySessionFactory.getCurrentSession();
//		String sql="from NhanVien";
//		List<NhanVien> nv= session.createQuery(sql).getResultList();
//		for(NhanVien n:nv)
//		{
//			System.out.println(n.getTennhanvien()+" "+n.getTuoi());
//		}
//		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("IoC.xml");
//        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		Resource resource=new ClassPathResource("IoC.xml");  
		BeanFactory factory=new XmlBeanFactory(resource);  
		 HelloWorld obj =(HelloWorld) factory.getBean("helloWorld");
        obj.getMessage();
		List<SanPham> sanPhams=sanPham_Service.Laydanhsachsanpham();
		for(SanPham sp:sanPhams)
		{
			System.out.println(sp.getName()+" "+sp.getId());
		}
		return "trangchu";
	}
	@GetMapping("/dm")
	public String dm()
	{
		return "index";
	}
	@PostMapping("mm")
	public String login(@RequestParam String username, @RequestParam String password, ModelMap login)
	{
		List<SanPham> sanPhams=sanPham_Service.Laydanhsachsanpham();
		login.addAttribute("sp",sanPhams);
		login.addAttribute("username", username);
		login.addAttribute("password", password);
		return "trangchu";
	}
	@RequestMapping("dung")
	public String test()
	{
		return "index";
	}
}
