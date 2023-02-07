package com.bookshop.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest()
//@DataJpaTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("spring-test-config.xml")

@SpringBootTest
@AutoConfigureMockMvc
public class ProductT {

//	@Autowired
//	private ProductController productController;

	@Autowired
	private MockMvc mvc;

	@Test
	public void getProductsTest() {
		System.out.println("executed");

	}
}
