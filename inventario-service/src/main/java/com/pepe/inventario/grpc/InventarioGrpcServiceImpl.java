package com.pepe.inventario.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class InventarioGrpcServiceImpl extends InventarioServiceGrpc.InventarioServiceImplBase{
    @Override
    public void getStock(StockRequest request, StreamObserver<StockResponse> responseObserver){
        int cantidad=42;
        StockResponse stockResponse=StockResponse.newBuilder().setCantidad(cantidad).build();
        responseObserver.onNext(stockResponse);
        responseObserver.onCompleted();


    }

}
