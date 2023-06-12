package com.application.gateway;

import io.smallrye.mutiny.Multi;

public interface ListProductService {
    Multi<ModelProduct> obtenerProductos();
}
