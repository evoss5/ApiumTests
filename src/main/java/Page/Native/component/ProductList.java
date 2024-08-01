package Page.Native.component;

public enum ProductList {

    SAUCE_LABS_BACKPACK("Sauce Labs Backpack"),
    SAUCE_LABS_BACKLIGHT("Sauce Labs Bike Light"),
    SAUCE_LABS_BOLT_TSHIRT("Sauce Labs Bolt T-Shirt"),
    SAUCE_LABS_FLEECE_JACKET("Sauce Labs Fleece Jacket"),
    SAUCE_LABS_ONESIE("Sauce Labs Onesie"),
    TEST_ALL_THINGS("Test.allTheThings() T-Shirt");



    private final String productName;

    ProductList(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
}
