package come.imagine.world;

import com.imagine.world.dao.ProductDAO;
import com.imagine.world.dao.UserDAO;
import com.imagine.world.dao.impl.ProductDAOImpl;
import com.imagine.world.models.Product;
import com.imagine.world.models.UserEntity;
import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by letuan on 2/5/14.
 */
public class DatabaseConnectionTest extends TestCase{
    ProductDAO productDAO = new ProductDAOImpl();

    public Product generateFakeProduct(){
        Product product = new Product();
        product.setDescription("DDDDD");
        product.setLastUpdateDate(new Long(System.currentTimeMillis()/1000).intValue());
        product.setName("NAME");
        product.setPrice("1234567");
        product.setProductAmount(1000);
        product.setProductCode("xxxx");

        return product;
    }

    @Override
    protected void setUp() throws Exception {

        productDAO.save(generateFakeProduct());

    }

    public void testConnectFindSomething(){
        List<Product> productList =  productDAO.findAll();
        assertTrue(productList.size()>0);

    }

    public void testFindUser() throws ParseException {
        UserDAO userDAO = new UserDAO();
        UserEntity userEntity= userDAO.getUserByUsername("playernodie19");
        System.out.println(userEntity.getBirthday());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.parse(userEntity.getBirthday());
    }

}
