package com.yc.biz.test;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.Favorite;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.TagBiz;

//junit启动,就会自动地：ApplicationContext ac=new 
//创建容器自动轻了
@RunWith(SpringJUnit4ClassRunner.class)
// 值：springJUnit4ClassRunner表示使用spring
// junit测试-》区别：自动完成ioc,di
// jUnit表示使用原生的junit测试
@ContextConfiguration({ "classpath:applicationContext.xml",
		"classpath:applicationContext-dao.xml" })
// 告诉容器
public class TestBizImpl {
	@Resource(name = "tagBizImpl")
	private TagBiz tagBiz;
	@Resource(name = "favoriteBizImpl")
	private FavoriteBiz favoriteBiz;

	@Test//测试添加一个全新的网址，且标签也是全新的
	public void testAdd() throws Exception {
		Map map = tagBiz.findAllTag();
		// 添加一个没哟的网址
		Favorite f = new Favorite();
		f.setFlabel("网易5");
		f.setFtags("新闻,游戏");
		f.setFdesc("大网站");
		f.setFurl("http://www.163.com");
		favoriteBiz.addFavorite(f, map);
	}
	@Test//测试添加一个全新的网址，且标签也是全新的
	public void testAdd2() throws Exception {
		Map map = tagBiz.findAllTag();
		// 添加一个没哟的网址
		Favorite f = new Favorite();
		f.setFlabel("网易7");
		f.setFtags("新闻1,门户");
		f.setFdesc("大网站");
		f.setFurl("http://www.162.com");
		favoriteBiz.addFavorite(f, map);
	}
	@Test//测试添加一个全新的网址，且标签也是全新的
	public void testAdd5() throws Exception {
		Map map = tagBiz.findAllTag();
		// 添加一个没哟的网址
		Favorite f = new Favorite();
		f.setFlabel("网易9");
		f.setFtags("娱乐");
		f.setFdesc("大网站");
		f.setFurl("http://www.166.com");
		favoriteBiz.addFavorite(f, map);
	}
	@Test//测试添加一个全新的网址，且标签也是全新的
	public void testAdd3() throws Exception {
		Map map = tagBiz.findAllTag();
		// 添加一个没哟的网址
		Favorite f = new Favorite();
		f.setFlabel("网易5");
		f.setFtags("");
		f.setFdesc("大网站");
		f.setFurl("http://www.1634.com");
		favoriteBiz.addFavorite(f, map);
	}
	/**
	 * 查询所有标签
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		
		System.out.println(tagBiz.findAllTag());
	}
	/**
	 * 查询没有分类的网址
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Favorite f = new Favorite();
		f.setTname("未分类");
		System.out.println(favoriteBiz.findFavoriteByTagName(f));
	}
	/**
	 * 查询所有的网址
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Favorite f = new Favorite();
		f.setTname(null);
		System.out.println(favoriteBiz.findFavoriteByTagName(f));
	}
	/**
	 * 按标签名查询网址
	 */
	@Test
	public void test4() {
		Favorite f = new Favorite();
		f.setTname("娱乐");
		System.out.println(favoriteBiz.findFavoriteByTagName(f));
	}
}
