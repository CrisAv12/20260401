package principal.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import principal.Configs.KafkaOrdenEventConsumer;
import principal.Models.Producto;
import principal.Repositories.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);
    @Autowired
    private ProductoRepository productoRepository;
    public Producto guardar(Producto producto) {
        logger.info("Guardando producto");
        return productoRepository.save(producto);
    }
    public Producto getById(Long id) {
        //return productoRepository.findById(id).get();
        logger.info("Buscando producto");
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
    public List<Producto> getTodos() {
        logger.info("Buscando todos los productos");
        return productoRepository.findAll();
    }
}
