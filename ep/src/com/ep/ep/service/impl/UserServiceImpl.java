package com.ep.ep.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ep.ep.dao.focustable.IFocustableDao;
import com.ep.ep.dao.shop_cart.IShop_CartDao;
import com.ep.ep.dao.user.IUserDao;
import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Orderitem;
import com.ep.ep.entity.Shop_cart;
import com.ep.ep.entity.User;
import com.ep.ep.service.UserService;
@Service("userservice")
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
	@Autowired
	IUserDao ud;
	@Autowired
	IShop_CartDao sc;
	@Autowired
	IFocustableDao fd;

	
	@Override
	//用户注册
	public void addUser(User user) {
		ud.addUser(user);
	}

	@Override
	//用户登录（传入用户名和密码查找数据库中相应的信息）
	public User login(String username, String password) {
		User user=ud.login(username, password);
		return user;
	}

	@Override
	//通过Uid查找用户（查看个人信息）
	public User findUserByUid(Integer uid) {
		User user=ud.findUserByUid(uid);
		return user;
	}

	@Override
	//更新用户
	public void updataUser(User user) {
		ud.updateUser(user);
		
	}

	@Override
	//查看个人/用户收藏夹
	public User checkFoucstable(Integer uid) {
		User user=ud.checkFocustable(uid);
		return user;
	}

	@Override
	//用户查看购物车，查看是同时更新总价
	public List<Shop_cart> checkShopCart(Integer uid) {
		//
		List<Shop_cart> shop_carts=ud.checkShopCart(uid);
		//遍历List集合，计算一项购物项的总价=商品单价*数量
		for(Shop_cart shop_cart:shop_carts){
			//计算总价
			double amount= shop_cart.getProducts().getPrice()*shop_cart.getShoppingnum();
			shop_cart.setAmount(amount);
			//更新总价
			sc.updataShop_Cart(shop_cart);
		}
		//返回list集合
		return shop_carts;
	}

	@Override
	//更新购物车
	public void updateProductnum(Shop_cart shop_cart) {
		sc.updataShop_Cart(shop_cart);
		
	}

	@Override
	//通过购物车项cid查看购物车（用于变更商品数量时更新总价）
	public Shop_cart findShop_CartByCid(Integer cid) {
		Shop_cart shop_cart=sc.findShop_CartByCid(cid);
		return shop_cart;
	}

	@Override
	//用户下单
	public void place_orderByUid(Orderbase orderbase) {
		ud.place_orderByUid(orderbase);
		
	}

	@Override
	//计算购物车总价
	public double Amount(Integer uid) {
		List<Shop_cart> shop_carts = ud.checkShopCart(uid);
		if(shop_carts.size()>0){
			double allAmount = 0;
			//遍历List集合，计算一项购物项的总价=商品单价*数量并且返回总价
			for (Shop_cart shop_cart : shop_carts) {
				double amount = shop_cart.getProducts().getPrice() * shop_cart.getShoppingnum();
				shop_cart.setAmount(amount);
				allAmount += shop_cart.getAmount();
			}
			return allAmount;
		}
		double result=0;
		return result;
	}

	@Override
	//级联插入订单详情
	public void place_orderByOrid(Orderitem orderitem) {
		ud.place_orderByOrid(orderitem);
		
	}

	@Override
	//下单的同时清除购物车
	public void deleteShop_cartByCid(Integer cid) {
		sc.deleteShop_CartByCid(cid);
		
	}

	@Override
	////查看订单
	public List<Orderbase> checkOrderByUid(Map<String, Object> params) {
	List<Orderbase> orderbases=	ud.checkOrderByUid(params);
		return orderbases;
	}

	@Override
	//计算用户订单总数
	public int count(Integer uid) {
		int count =ud.count(uid);
		return count;
	}

	@Override
	////查看详情订单（包括商品名称，数量，单价，折后价）
	public List<Orderitem> checkOrderItemByOrdi(Map<String, Object> params) {
		List<Orderitem> orderitems=ud.checkOrderItemByOrdi(params);
		return orderitems;
	}

	@Override
	//计算每项订单商品总数
	public int productCount(Integer orid) {
		int count=ud.productCount(orid);
		return count;
	}

	@Override
	//删除收藏夹里的商品项（取消收藏）
	public void deleteFocustable(Integer pid) {
		fd.deleteFocustableByPid(pid);
		
	}

	@Override
	//通过用户名查找用户
	public User findUserByUname(String username) {
		User user=ud.findUserByUname(username);
		return user;
	}

	@Override
	//通过email查找用户
	public User findByEmail(String email) {
		User user=ud.findByEmail(email);
		return user;
	}

	@Override
	//通过phone查找用户
	public User findByPhone(String phone) {
		User user=ud.findByPhone(phone);
		return user;
	}

	


	

	
}
