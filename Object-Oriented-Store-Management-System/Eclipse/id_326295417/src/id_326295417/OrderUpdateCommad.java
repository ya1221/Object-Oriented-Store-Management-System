package id_326295417;

public class OrderUpdateCommad implements Command {
	private SystemProduct system_product;
	private static OrderUpdateCommad _instance = null;

	private OrderUpdateCommad(SystemProduct systemProduct) {
		this.system_product = systemProduct;
	}

	public static OrderUpdateCommad getOrderUpdateCommad(SystemProduct systemProduct) {
		if (_instance == null)
			_instance = new OrderUpdateCommad(systemProduct);
		return _instance;
	}

	@Override
	public Order undoOrder() {
		if (this.system_product.getAllOrderStack().size() != 0) {
			Order order = this.system_product.getAllOrderStack().pop();
			order.getProduct().reduceStock(-order.getAmount());
			order.getProduct().getOrderSet().remove(order);
			return order;
		}
		return null;
	}
}
