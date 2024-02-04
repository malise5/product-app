package ProductControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.malise.app.AppApplication;
import com.malise.app.Exceptions.ProductNotValidException;
import com.malise.app.model.product.Product;
import com.malise.app.repository.product.ProductRepository;
import com.malise.app.service.product.commandhandlers.CreateProductCommandHandler;

@SpringBootTest(classes = AppApplication.class)
public class CreateProductCommandHandlerTest {

  @InjectMocks
  private CreateProductCommandHandler createProductCommand;

  @Mock
  private ProductRepository productRepository;

  @Test
  public void createProductCommandHandler_validProduct_returnsSuccess() {

    // Given
    Product product = new Product();
    product.setId(1);
    product.setName("Xbox");
    product.setPrice(9.99);
    product.setDescription("playing on Microsoft");
    product.setQuantity(20);

    // when
    ResponseEntity response = createProductCommand.execute(product);

    // then
    assertEquals(HttpStatus.OK, response.getStatusCode());

  }

  @Test
  public void createProductCommandHandler_invalidPrice_throwsInvalidPriceException() {

    Product product = new Product();
    product.setId(1);
    product.setName("Xbox");
    product.setPrice(-9.99);
    product.setDescription("playing on Microsoft");
    product.setQuantity(20);

    ProductNotValidException exception = assertThrows(ProductNotValidException.class,
        () -> createProductCommand.execute(product));

    assertEquals("Product Price cannot be less than zero", exception.getSimpleResponse().getMessage());

  }

}
