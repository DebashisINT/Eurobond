package com.breezeeurobondfsm.features.login.api.productlistapi

/**
 * Created by Saikat on 20-11-2018.
 */
object ProductListRepoProvider {
    fun productListProvider(): ProductListRepo {
        return ProductListRepo(ProductListApi.create())
    }
}