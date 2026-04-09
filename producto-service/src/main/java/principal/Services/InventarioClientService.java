package principal.Services;

import com.pepe.inventario.grpc.InventarioServiceGrpc;
import com.pepe.inventario.grpc.StockRequest;
import com.pepe.inventario.grpc.StockResponse;
import org.springframework.stereotype.Service;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class InventarioClientService {
    @GrpcClient("inventario-service")
    private InventarioServiceGrpc.InventarioServiceBlockingStub inventarioServiceBlockingStub;
    public int obtenerStockGrpc(Long idProducto){
        StockRequest request=StockRequest.newBuilder().setProductoId(idProducto).build();
        //StockResponse response= InventarioServiceGrpc.inventarioServiceBlockingStub.getStock(request);
        StockResponse response= inventarioServiceBlockingStub.getStock(request);
        return (int) response.getCantidad();
    }
}
