package SportsMall.entity;

 	 
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

 

public class Cart {
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private int price;

	public Map<Integer, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}

	public int getPrice() {
		int totalPrice = 0;
		// for循环：遍历整个购物项
		for (Entry<Integer, CartItem> entry : map.entrySet()) {
			CartItem carItem = map.get(entry.getKey());
			totalPrice = totalPrice + carItem.getPrice();
			this.price = totalPrice;
		}
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void addItem(Product_zuqiu product) {
		if (map.containsKey(product.getId())) {
			CartItem cartItem = map.get(product.getId());
			cartItem.setCount(cartItem.getCount() + 1);

		} else {
			CartItem item = new CartItem();
			item.setProduct(product);
			item.setCount(1);
			map.put(product.getId(), item);
		}

	}
	public boolean deleteItem(Product_zuqiu product){
		if(map.containsKey(product.getId())){
			CartItem cartItem=map.get(product.getId());
			if(cartItem.getCount()!=0){
				cartItem.setCount(cartItem.getCount()-1);
				if(cartItem.getCount()==0){
					map.remove(product.getId());
				}
			}
		}
		return false;
	}

	public Collection<CartItem> getCartItems(){
		return map.values();
	}

}
