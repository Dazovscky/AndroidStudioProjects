package my.layoutinflaterlis.start.com.customadapter;

/**
 * Created by Artem on 26.11.2017.
 */

public class Product {
    String name;
    int price;
    int image;
    boolean box;

    Product(String _describle, int _price, int _image,
            boolean _box){
        name=_describle;
        price=_price;
        image=_image;
        box=_box;
    }
}
