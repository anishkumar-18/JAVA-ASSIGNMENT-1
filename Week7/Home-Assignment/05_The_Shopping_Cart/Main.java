class Cart {
    private final double[] prices;
    private int count;
    private final String cartId;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
    }

    void addItem(double price) {
        if (price >= 0 && count < prices.length) {
            prices[count++] = price;
        }
    }

    double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    int getItemCount() {
        return count;
    }

    String getCartId() {
        return cartId;
    }
}

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Count: " + cart.getItemCount());
    }
}
